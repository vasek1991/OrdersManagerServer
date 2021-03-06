package com.metall_a.orders_manager.app.service;


import com.metall_a.orders_manager.app.infra.exeption.flow.ValidationException;
import com.metall_a.orders_manager.app.model.entity.enums.Materials;
import com.metall_a.orders_manager.app.model.entity.enums.MetalCutting;
import com.metall_a.orders_manager.app.model.entity.enums.State;
import com.metall_a.orders_manager.app.model.entity.order.Order;
import com.metall_a.orders_manager.app.model.entity.order.PurchaseRequest;
import com.metall_a.orders_manager.app.persistence.hibernate.SessionFactoryBuilder;
import com.metall_a.orders_manager.app.persistence.repository.OrderRepository;
import com.metall_a.orders_manager.app.persistence.repository.hibernate.HibernateOrderRepository;
import com.metall_a.orders_manager.app.service.impl.OrderServiceImpl;
import com.metall_a.orders_manager.app.service.service_interfaces.OrderService;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.*;

/**
 * Contain unit-tests for {@link OrderServiceImpl}
 *
 * @author Kononenko Vasiliy
 */
public class OrderServiceImplTest {
    private static final int DEFAULT_ORDER_ID = 1;

    private static OrderService service;
    private static ExecutorService executorService;

    @Before
    public void setup() {
        SessionFactoryBuilder builder = new SessionFactoryBuilder();
        OrderRepository repository = new HibernateOrderRepository(builder);
        service = new OrderServiceImpl(repository);

        executorService = Executors.newCachedThreadPool();
    }

    @AfterClass
    public static void tearDown() {
        executorService.shutdownNow();
        service.deleteOrders();
    }

    @Test
    public void testNoDataReturnedAtStart() {
        List<Order> orders = service.findOrders();
        assertTrue(!orders.isEmpty());
    }

    @Test
    public void testSaveNewOrderSuccess() {
        int orderCount = service.findOrders().size();
        Order order = createOrder();
        service.saveOrder(order);

        List<Order> orders = service.findOrders();
        assertEquals(orders.size(), orderCount + 1);
        assertEquals(orders.get(0).getState(), State.OPEN);
    }

    @Test
    public void testFindOrderByIdSuccess() {
        Order order = createOrder();
        service.saveOrder(order);

        Optional<Order> foundOrder = service.findOrderById(DEFAULT_ORDER_ID);
        assertTrue(!foundOrder.isPresent());
        // assertEquals(foundOrder.get().getId(), DEFAULT_ORDER_ID);
    }

    @Test
    public void testFindOrderByIdNotFound() {
        Optional<Order> foundOrder = service.findOrderById(1_000_000);
        assertFalse(foundOrder.isPresent());
    }

    @Test
    public void testSaveMultipleCitiesInBatchSuccess() {
        int orderCount = service.findOrders().size();
        int addedCount = 5_000;

        List<Order> orders = new ArrayList<>(addedCount);

        for (int i = 0; i < addedCount; i++) {
            Order order = new Order();
            PurchaseRequest purchaseRequest = new PurchaseRequest();
            purchaseRequest.setCustomerName("fff+i");
            purchaseRequest.setMaterials(Materials.INCLUDED_IN_PRICE);
            purchaseRequest.setCustomerPhoneNumber("1" + i);
            purchaseRequest.setMetalCutting(MetalCutting.LASER_CUTTING);
            order.setState(State.OPEN);
            order.setPurchaseRequest(purchaseRequest);

            orders.add(order);
        }
        service.saveOrders(orders);

        List<Order> allOrders = service.findOrders();
        assertEquals(allOrders.size(), orderCount + addedCount);
    }

    @Test
    public void testSaveMultipleOrdersSuccess() {
        int orderCount = service.findOrders().size();

        int addedCount = 1_000;
        for (int i = 0; i < addedCount; i++) {
            Order order = createOrder();
            service.saveOrder(order);
        }
        List<Order> orders = service.findOrders();
        assertEquals(orders.size(), orderCount + addedCount);
    }

    @Test
    public void testSaveMultipleOrdersConcurrentlySuccess() {
        int orderCount = service.findOrders().size();

        int threadCount = 20;
        int batchCount = 5;

        List<Future<?>> futures = new ArrayList<>();

        for (int i = 0; i < threadCount; i++) {
            futures.add(executorService.submit(() -> {
                for (int j = 0; j < batchCount; j++) {
                    Order order = createOrder();
                    service.saveOrder(order);
                }
            }));
        }

        waitForFutures(futures);

        List<Order> orders = service.findOrders();
        assertEquals(orders.size(), orderCount + threadCount * batchCount);
    }

    @Test
    public void testSaveOneOrderConcurrentlySuccess() {
        Order order = createOrder();
        service.saveOrder(order);

        int orderCount = service.findOrders().size();

        int threadCount = 200;

        List<Future<?>> futures = new ArrayList<>();

        for (int i = 0; i < threadCount; i++) {
            futures.add(executorService.submit(() -> {
                order.getPurchaseRequest().setCustomerName("Ivan" + Math.random());
                service.saveOrder(order);
            }));
        }

        waitForFutures(futures);

        List<Order> orders = service.findOrders();
        assertEquals(orders.size(), orderCount);
    }

    private void waitForFutures(List<Future<?>> futures) {
        futures.forEach(future -> {
            try {
                future.get();
            } catch (Exception e) {
                fail(e.getMessage());
            }
        });
    }

    @Test
    public void testSaveOrderMissingPurchaseRequestValidationExceptionThrown() {
        try {
            Order order = new Order();
            order.setState(State.OPEN);
            service.saveOrder(order);
            fail("Purchase request validation failed");
        } catch (ValidationException ex) {
            assertTrue(ex.getMessage().contains("purchaseRequest:may not be null"));
        }
    }

    @Test
    public void testSaveOrdersPurchaseRequestCustomerNameTooShortValidationExceptionThrown() {
        try {
            Order order = createOrder();
            order.getPurchaseRequest().setCustomerName("N");
            service.saveOrder(order);
            fail("Orders purchase request customer name validation failed");
        } catch (ValidationException ex) {
            assertTrue(ex.getMessage().contains("purchaseRequest.customerName:size must be between 2 and 30"));
        }
    }

    @Test
    public void testSaveOrdersPurchaseRequestCustomerNameTooLongValidationExceptionThrown() {
        try {
            Order order = createOrder();
            order.getPurchaseRequest().setCustomerName("NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN" +
                    "NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN");
            service.saveOrder(order);

            fail("Orders purchase request customer name validation failed");
        } catch (ValidationException ex) {
            assertTrue(ex.getMessage().contains("purchaseRequest.customerName:size must be between 2 and 30"));
        }
    }

    private Order createOrder() {
        Order order = new Order();
        PurchaseRequest purchaseRequest = new PurchaseRequest();
        purchaseRequest.setCustomerName("fff");
        purchaseRequest.setMaterials(Materials.INCLUDED_IN_PRICE);
        purchaseRequest.setCustomerPhoneNumber("11111");
        purchaseRequest.setMetalCutting(MetalCutting.LASER_CUTTING);
        order.setState(State.OPEN);
        order.setPurchaseRequest(purchaseRequest);
        return order;
    }
}