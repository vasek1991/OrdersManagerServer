package com.metall_a.orders_manager.app.service.service_interfaces;

import com.metall_a.orders_manager.app.model.entity.order.PurchaseRequest;

import java.util.List;
import java.util.Optional;

/**
 * Entry point to perform operations
 * over PurchaseRequest entities
 *
 * @author Vasiliy Kononenko
 */
public interface PurchaseRequestService {
    /**
     * Returns List of PurchaseRequests
     *
     * @return List of PurchaseRequests
     */
    List<PurchaseRequest> findPurchaseRequest();

    /**
     * Returns  Optional with PurchaseRequest with specified identifier.
     * If no PurchaseRequest is found then empty optional is
     * returned
     *
     * @param id int
     * @return Optional with PurchaseRequest
     */
    Optional<PurchaseRequest> findPurchaseRequestById(int id);

    /**
     * Saves specified PurchaseRequest instance
     *
     * @param purchaseRequest purchaseRequest
     */
    void savePurchaseRequest(PurchaseRequest purchaseRequest);

    /**
     * Deletes specified PurchaseRequest instance by id
     *
     * @param id int
     */
    void deletePurchaseRequest(int id);

    // /**
    // * Returns all the PurchaseRequest that match specified criteria
    //  * @param criteria
    //  * @param rangeCriteria
    //  * @return
    //  */
    /*List<PurchaseRequest> searchPurchaseRequests(StationCriteria criteria, RangeCriteria rangeCriteria);
*/
}