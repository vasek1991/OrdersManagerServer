package com.metall_a.orders_manager.app.persistence.repository.inmemory;

import com.metall_a.orders_manager.app.infra.util.CommonUtil;
import com.metall_a.orders_manager.app.model.entity.order.Order;
import com.metall_a.orders_manager.app.persistence.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * In-memory implementation of the {@link OrderRepository} that stores
 * data in the RAM
 *
 * @author Vasiliy Kononenko
 */
public class InMemoryOrderRepository implements OrderRepository {
    /**
     * Internal list of Orders
     */
    private final List<Order> orders;

    /**
     * Auto-increment counter for entity id generation
     */
    private int counter = 0;

    public InMemoryOrderRepository() {
        orders = new ArrayList<>();
    }

    @Override
    public void delete(final long purchaseRequestId) {
    }

    @Override
    public List<Order> findAll() {
        return CommonUtil.getSafeList(orders);
    }

    @Override
    public void deleteAll() {
        orders.clear();
    }

    @Override
    public void save(final Order order) {
        if (!orders.contains(order)) {
            order.setId(++counter);
            orders.add(order);
        }
    }

    @Override
    public Order findById(final long orderId) {
        return orders.stream()
                .filter(salesForm -> salesForm.getId() == orderId)
                .findFirst()
                .orElse(null);
    }
}