package com.metall_a.orders_manager.app.service.impl;

import com.metall_a.orders_manager.app.model.entity.order.Order;
import com.metall_a.orders_manager.app.persistence.repository.OrderRepository;
import com.metall_a.orders_manager.app.service.model_interfaces.OrderService;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

/**
 * Default implementation of the {@link OrderService}
 *
 * @author Vasiliy Kononenko
 */
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Inject
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findOrderById(int id) {
        return Optional.ofNullable(orderRepository.findById(id));
    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void deleteOrder(int id) {

    }
}