package com.metall_a.orders_manager.app.service.transform;


import com.metall_a.orders_manager.app.model.entity.enums.State;
import com.metall_a.orders_manager.app.model.entity.order.Order;
import com.metall_a.orders_manager.app.persistence.repository.inmemory.InMemoryOrderRepository;
import com.metall_a.orders_manager.app.service.impl.OrderServiceImpl;
import com.metall_a.orders_manager.app.service.model_interfaces.OrderService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Contain unit-tests for {@link OrderServiceImpl}
 *
 * @author Kononenko Vasiliy
 */
public class OrderServiceImplTest {
    private static final int DEFAULT_ORDER_ID = 1;

    private OrderService service;

    @Before
    public void setup() {
        service = new OrderServiceImpl(new InMemoryOrderRepository());
    }

    @Test
    public void testNoDataReturnedAtStart() {
        List<Order> purchaseRequests = service.findOrders();
        assertTrue(purchaseRequests.isEmpty());
    }

    @Test
    public void testSaveNewOrderSuccess() {
        Order order = new Order();
        order.setState(State.OPEN);
        service.saveOrder(order);

        List<Order> orders = service.findOrders();
        assertEquals(orders.size(), 1);
        assertEquals(orders.get(0).getState(), State.OPEN);
    }

    @Test
    public void testFindOrderByIdSuccess() {
        Order order = new Order();
        order.setState(State.OPEN);
        service.saveOrder(order);

        Optional<Order> foundOrder = service.findOrderById(DEFAULT_ORDER_ID);
        assertTrue(foundOrder.isPresent());
        assertEquals(foundOrder.get().getId(), DEFAULT_ORDER_ID);
    }

    @Test
    public void testFindPurchaseRequestByIdNotFound() {
        Optional<Order> foundOrder = service.findOrderById(DEFAULT_ORDER_ID);
        assertFalse(foundOrder.isPresent());
    }
}