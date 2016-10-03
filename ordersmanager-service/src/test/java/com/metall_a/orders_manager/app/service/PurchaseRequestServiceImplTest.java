package com.metall_a.orders_manager.app.service;

import com.metall_a.orders_manager.app.model.entity.order.PurchaseRequest;
import com.metall_a.orders_manager.app.persistence.repository.inmemory.InMemoryPurchaseRequestRepository;
import com.metall_a.orders_manager.app.service.impl.PurchaseRequestServiceImpl;
import com.metall_a.orders_manager.app.service.model_interfaces.PurchaseRequestService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Contain unit-tests for {@link PurchaseRequestServiceImpl
 *
 * @author Kononenko Vasiliy
 */
public class PurchaseRequestServiceImplTest {
    private static final int DEFAULT_PURCHASE_REQUEST_ID = 1;

    private PurchaseRequestService service;

    @Before
    public void setup() {
        service = new PurchaseRequestServiceImpl(new InMemoryPurchaseRequestRepository());
    }

    @Test
    public void testNoDataReturnedAtStart() {
        List<PurchaseRequest> purchaseRequests = service.findPurchaseRequest();
        assertTrue(purchaseRequests.isEmpty());
    }

    @Test
    public void testSaveNewPurchaseRequestSuccess() {
        PurchaseRequest purchaseRequest = new PurchaseRequest();
        purchaseRequest.setMaterialsNote("param");
        service.savePurchaseRequest(purchaseRequest);

        List<PurchaseRequest> purchaseRequests = service.findPurchaseRequest();
        assertEquals(purchaseRequests.size(), 1);
        assertEquals(purchaseRequests.get(0).getMaterialsNote(), "param");
    }

    @Test
    public void testFindPurchaseRequestByIdSuccess() {
        PurchaseRequest purchaseRequest = new PurchaseRequest();
        purchaseRequest.setMaterialsNote("param");
        service.savePurchaseRequest(purchaseRequest);

        Optional<PurchaseRequest> foundPurchaseRequest = service.findPurchaseRequestById(DEFAULT_PURCHASE_REQUEST_ID);
        assertTrue(foundPurchaseRequest.isPresent());
        assertEquals(foundPurchaseRequest.get().getId(), DEFAULT_PURCHASE_REQUEST_ID);
    }

    @Test
    public void testFindPurchaseRequestByIdNotFound() {
        Optional<PurchaseRequest> foundPurchaseRequest = service.findPurchaseRequestById(DEFAULT_PURCHASE_REQUEST_ID);
        assertFalse(foundPurchaseRequest.isPresent());
    }
}