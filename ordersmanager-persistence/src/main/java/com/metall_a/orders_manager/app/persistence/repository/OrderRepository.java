package com.metall_a.orders_manager.app.persistence.repository;

import com.metall_a.orders_manager.app.model.entity.order.Order;

import java.util.List;

/**
 * Defines CRUD methods to access Order objects in the persistent storage
 *
 * @author Kononenko Vasiliy
 */
public interface OrderRepository {
    /**
     * Saves(creates or modifies) specified Order instance
     *
     * @param order Order
     */
    void save(Order order);

    /**
     * Returns Order with specified identifier. If no Order exists with such identifier
     * then null is returned
     *
     * @param orderId long
     * @return Order
     */
    Order findById(long orderId);

    /**
     * Delete Order with specified identifier
     *
     * @param orderId long
     */
    void delete(long orderId);

    /**
     * Returns all the Orders
     *
     * @return List of Orders
     */
    List<Order> findAll();

    /**
     * Deletes all the orders
     */
    void deleteAll();

    /**
     * Saves specified order instances
     *
     * @param orders List of Orders
     */
    void saveAll(List<Order> orders);
}