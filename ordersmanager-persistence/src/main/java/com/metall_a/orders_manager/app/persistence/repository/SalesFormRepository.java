package com.metall_a.orders_manager.app.persistence.repository;

import com.metall_a.orders_manager.app.model.entity.order.SalesForm;

import java.util.List;

/**
 * Defines CRUD methods to access SalesForm objects in the persistent storage
 *
 * @author Kononenko Vasiliy
 */
public interface SalesFormRepository {
    /**
     * Saves(creates or modifies) specified sales form instance
     *
     * @param salesForm f
     */
    void save(SalesForm salesForm);

    /**
     * Returns sales form with specified identifier. If no city exists with such identifier
     * then null is returned
     *
     * @param salesFormId f
     * @return f
     */
    SalesForm findById(int salesFormId);

    /**
     * Delete sales form with specified identifier
     *
     * @param salesFormId f
     */
    void delete(int salesFormId);

    /**
     * Returns all the sales form
     *
     * @return f
     */
    List<SalesForm> findAll();
}