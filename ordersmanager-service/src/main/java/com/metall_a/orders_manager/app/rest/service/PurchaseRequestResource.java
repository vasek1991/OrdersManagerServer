package com.metall_a.orders_manager.app.rest.service;

import com.metall_a.orders_manager.app.model.entity.order.PurchaseRequest;
import com.metall_a.orders_manager.app.rest.dto.PurchaseRequestDTO;
import com.metall_a.orders_manager.app.rest.service.base.BaseResource;
import com.metall_a.orders_manager.app.service.service_interfaces.PurchaseRequestService;
import com.metall_a.orders_manager.app.service.transform.Transformer;
import org.apache.commons.lang3.math.NumberUtils;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * {@link PurchaseRequestResource} is REST web-service that handles purchase requests department-related requests
 *
 * @author Vasiliy Kononenko
 */
@Path("purchase-requests")
public class PurchaseRequestResource extends BaseResource {
    /**
     * Underlying source of data
     */
    private final PurchaseRequestService service;

    /**
     * DTO <-> Entity transformer
     */
    private final Transformer transformer;

    @Inject
    public PurchaseRequestResource(PurchaseRequestService service, Transformer transformer) {
        this.transformer = transformer;
        this.service = service;

        PurchaseRequest purchaseRequest = new PurchaseRequest();
        purchaseRequest.setMaterialsNote("ffff");
        purchaseRequest.setCustomerNote("aaaa");
        purchaseRequest.setPaintingOperationNote("bbbb");
        service.savePurchaseRequest(purchaseRequest);
    }

    /**
     * Saves new PurchaseRequest instance
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void savePurchaseRequest(PurchaseRequestDTO purchaseRequestDTO) {
        service.savePurchaseRequest(transformer.untransform(purchaseRequestDTO, PurchaseRequest.class));
    }

    /**
     * Returns all the existing PurchaseRequests
     *
     * @return List of PurchaseRequests
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PurchaseRequestDTO> findPurchaseRequests() {
        return service.findPurchaseRequest().stream().map((salesForm) -> transformer.transform(salesForm, PurchaseRequestDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Returns PurchaseRequest with specified identifier
     *
     * @return Response
     */
    @Path("/{salesFormId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findPurchaseRequestById(@PathParam("salesFormId") final String cityId) {
        if (!NumberUtils.isNumber(cityId)) {
            return BAD_REQUEST;
        }

        Optional<PurchaseRequest> purchaseRequest = service.findPurchaseRequestById(NumberUtils.toInt(cityId));
        if (!purchaseRequest.isPresent()) {
            return NOT_FOUND;
        }
        return ok(transformer.transform(purchaseRequest.get(), PurchaseRequestDTO.class));
    }
}