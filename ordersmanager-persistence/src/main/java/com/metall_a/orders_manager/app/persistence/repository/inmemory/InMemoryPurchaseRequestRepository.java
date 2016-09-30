package com.metall_a.orders_manager.app.persistence.repository.inmemory;


import com.metall_a.orders_manager.app.infra.util.CommonUtil;
import com.metall_a.orders_manager.app.model.entity.order.PurchaseRequest;
import com.metall_a.orders_manager.app.persistence.repository.PurchaseRequestRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * In-memory implementation of the {@link PurchaseRequestRepository} that stores
 * data in the RAM
 *
 * @author Vasiliy Kononenko
 */
public class InMemoryPurchaseRequestRepository implements PurchaseRequestRepository {
    /**
     * Internal list of PurchaseRequests
     */
    private final List<PurchaseRequest> purchaseRequests;

    /**
     * Auto-increment counter for entity id generation
     */
    private int counter = 0;

    public InMemoryPurchaseRequestRepository() {
        purchaseRequests = new ArrayList<>();
    }

    @Override
    public void delete(final int purchaseRequestId) {
    }

    @Override
    public List<PurchaseRequest> findAll() {
        return CommonUtil.getSafeList(purchaseRequests);
    }

    @Override
    public void save(final PurchaseRequest purchaseRequest) {
        if (!purchaseRequests.contains(purchaseRequest)) {
            purchaseRequest.setId(++counter);
            purchaseRequests.add(purchaseRequest);
        }
    }

    @Override
    public PurchaseRequest findById(final int purchaseRequestId) {
        return purchaseRequests.stream()
                .filter(salesForm -> salesForm.getId() == purchaseRequestId)
                .findFirst()
                .orElse(null);
    }
}