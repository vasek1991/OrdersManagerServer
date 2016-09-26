package com.metall_a.orders_manager.app.service.model_interfaces;

import com.metall_a.orders_manager.app.model.entity.order.SalesForm;

import java.util.List;

/**
 * Entry point to perform operations
 * over sales form entities
 *
 * @author Vasiliy Kononenko
 */
public interface SalesFormService {
    /**
     * Returns list of sales form
     *
     * @return list of sales form
     */
    List<SalesForm> findSalesForms();

    /**
     * Saves specified person instance
     *
     * @param salesForm sales form
     */
    void saveSalesForm(SalesForm salesForm);

    /**
     * Deletes specified salesForm instance by id
     *
     * @param id int
     */
    void deleteSalesForm(int id);

    /**
     * Updates specified salesForm instance
     *
     * @param salesForm salesForm
     */
    void updateSalesForm(SalesForm salesForm);
}