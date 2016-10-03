package com.metall_a.orders_manager.app.service.impl;

import com.metall_a.orders_manager.app.infra.exeption.flow.ValidationException;
import com.metall_a.orders_manager.app.model.entity.order.Order;
import com.metall_a.orders_manager.app.persistence.repository.OrderRepository;
import com.metall_a.orders_manager.app.service.model_interfaces.OrderService;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Default implementation of the {@link OrderService}
 *
 * @author Vasiliy Kononenko
 */
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final Validator validator;

    @Inject
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

    }

    @Override
    public void saveOrder(Order order) {
        Set<ConstraintViolation<Order>> constraintViolations = validator.validate(order);
        if (!constraintViolations.isEmpty()) {
            throw new ValidationException("Order validation failure", constraintViolations);
        }
        orderRepository.save(order);
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
    public void deleteOrder(int id) {

    }
}