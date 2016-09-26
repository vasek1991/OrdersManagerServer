package com.metall_a.orders_manager.app.service.model_interfaces;

import com.metall_a.orders_manager.app.model.entity.order.SalesForm;

import java.util.List;
import java.util.Optional;

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
     * Returns city with specified identifier. If no city is found then empty optional is
     * returned
     *
     * @param id ff
     * @return ff
     */
    Optional<SalesForm> findSalesFormById(int id);


    /**
     * Saves specified person instance
     *
     * @param salesForm sales form
     */
    void saveSalesForm(SalesForm salesForm);

    // /**
    // * Returns all the stations that match specified criteria
    //  * @param criteria
    //  * @param rangeCriteria
    //  * @return
    //  */
    /*List<Station> searchStations(StationCriteria criteria, RangeCriteria rangeCriteria);
*/


    /**
     * Deletes specified salesForm instance by id
     *
     * @param id int
     */
    void deleteSalesForm(int id);
}