package com.metall_a.orders_manager.app.service.impl;

import com.metall_a.orders_manager.app.model.entity.order.PurchaseRequest;
import com.metall_a.orders_manager.app.persistence.repository.PurchaseRequestRepository;
import com.metall_a.orders_manager.app.service.model_interfaces.PurchaseRequestService;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

/**
 * Default implementation of the {@link PurchaseRequestService}
 *
 * @author Vasiliy Kononenko
 */
public class PurchaseRequestServiceImpl implements PurchaseRequestService {
    private final PurchaseRequestRepository purchaseRequestRepository;

    @Inject
    public PurchaseRequestServiceImpl(PurchaseRequestRepository purchaseRequestRepository) {
        this.purchaseRequestRepository = purchaseRequestRepository;
    }

    @Override
    public List<PurchaseRequest> findPurchaseRequest() {
        return purchaseRequestRepository.findAll();
    }

    @Override
    public Optional<PurchaseRequest> findPurchaseRequestById(int id) {
        return Optional.ofNullable(purchaseRequestRepository.findById(id));
    }

    @Override
    public void savePurchaseRequest(PurchaseRequest purchaseRequest) {
        purchaseRequestRepository.save(purchaseRequest);
    }

    @Override
    public void deletePurchaseRequest(int id) {
    }
}