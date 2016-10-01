package com.metall_a.orders_manager.app.rest.service;

import com.metall_a.orders_manager.app.rest.dto.PurchaseRequestDTO;
import com.metall_a.orders_manager.app.rest.service.config.JerseyConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * {@link PurchaseRequestResourceTest} is integration test that verifies
 * {@link PurchaseRequestResource}
 *
 * @author Kononenko Vasiliy
 */
public class PurchaseRequestResourceTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new JerseyConfig();
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testFindPurchaseRequestSuccess() {
        List<Map<String, String>> purchaseRequests = target("purchase-requests").request().get(List.class);
        assertNotNull(purchaseRequests);
        assertEquals(purchaseRequests.size(), 1);

        Map<String, String> purchaseRequest = purchaseRequests.get(0);
        assertEquals(purchaseRequest.get("materialsNote"), "ffff");
        assertEquals(purchaseRequest.get("customerNote"), "aaaa");
        assertEquals(purchaseRequest.get("paintingOperationNote"), "bbbb");
    }

    @Test
    public void testFindPurchaseRequestByIdSuccess() {
        PurchaseRequestDTO purchaseRequest = target("purchase-requests/1").request().get(PurchaseRequestDTO.class);
        assertNotNull(purchaseRequest);
        assertEquals(purchaseRequest.getId(), 1);
        assertEquals(purchaseRequest.getMaterialsNote(), "ffff");
        assertEquals(purchaseRequest.getCustomerNote(), "aaaa");
        assertEquals(purchaseRequest.getPaintingOperationNote(), "bbbb");
    }

    @Test
    public void testFindPurchaseRequestByIdNotFound() {
        Response response = target("purchase-requests/2").request().get(Response.class);
        assertNotNull(response);
        assertEquals(response.getStatus(), Response.Status.NOT_FOUND.getStatusCode());
    }

    @Test
    public void testFindPurchaseRequestByIdInvalidId() {
        Response response = target("purchase-requests/aaab").request().get(Response.class);
        assertNotNull(response);
        assertEquals(response.getStatus(), Response.Status.BAD_REQUEST.getStatusCode());
    }

    @Test
    public void testSavePurchaseRequestSuccess() {
        PurchaseRequestDTO purchaseRequestDTO = new PurchaseRequestDTO();
        purchaseRequestDTO.setMaterialsNote("gggg");
        Response response = target("purchase-requests").request().post(Entity.entity(purchaseRequestDTO, MediaType.APPLICATION_JSON));
        assertEquals(response.getStatus(), Response.Status.NO_CONTENT.getStatusCode());
    }
}