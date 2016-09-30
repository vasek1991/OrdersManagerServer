package com.metall_a.orders_manager.app.persistence.repository;

import com.metall_a.orders_manager.app.model.entity.order.PurchaseRequest;

import java.util.List;

/**
 * Defines CRUD methods to access PurchaseRequest objects in the persistent storage
 *
 * @author Kononenko Vasiliy
 */
public interface PurchaseRequestRepository {
    /**
     * Saves(creates or modifies) specified PurchaseRequest instance
     *
     * @param purchaseRequest PurchaseRequest
     */
    void save(PurchaseRequest purchaseRequest);

    /**
     * Returns PurchaseRequest with specified identifier. If no PurchaseRequest exists with such identifier
     * then null is returned
     *
     * @param purchaseRequestId int
     * @return PurchaseRequest
     */
    PurchaseRequest findById(int purchaseRequestId);

    /**
     * Delete PurchaseRequest with specified identifier
     *
     * @param purchaseRequestId int
     */
    void delete(int purchaseRequestId);

    /**
     * Returns all the PurchaseRequests
     *
     * @return List of PurchaseRequests
     */
    List<PurchaseRequest> findAll();
}