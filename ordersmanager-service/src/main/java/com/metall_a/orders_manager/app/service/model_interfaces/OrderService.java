package com.metall_a.orders_manager.app.service.model_interfaces;

import com.metall_a.orders_manager.app.model.entity.order.Order;

import java.util.List;
import java.util.Optional;

/**
 * Entry point to perform operations
 * over Orders entities
 *
 * @author Vasiliy Kononenko
 */
public interface OrderService {
    /**
     * Returns List of Orders
     *
     * @return List of Orders
     */
    List<Order> findOrders();

    /**
     * Returns Optional with Order by specified identifier. If no Order is found then empty optional is
     * returned
     *
     * @param id id
     * @return Optional with Order
     */
    Optional<Order> findOrderById(int id);

    /**
     * Saves specified Order instance
     *
     * @param order Order
     */
    void saveOrder(Order order);

    /**
     * Deletes specified Order instance by id
     *
     * @param id int
     */
    void deleteOrder(int id);
}