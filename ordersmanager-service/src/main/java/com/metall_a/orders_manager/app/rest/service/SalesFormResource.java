package com.metall_a.orders_manager.app.rest.service;

import com.metall_a.orders_manager.app.model.entity.order.SalesForm;
import com.metall_a.orders_manager.app.rest.dto.SalesFormDTO;
import com.metall_a.orders_manager.app.rest.service.base.BaseResource;
import com.metall_a.orders_manager.app.service.model_interfaces.SalesFormService;
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
 * {@link SalesFormResource} is REST web-service that handles sales department-related requests
 *
 * @author Vasiliy Kononenko
 */
@Path("sales-forms")
public class SalesFormResource extends BaseResource {
    /**
     * Underlying source of data
     */
    private final SalesFormService service;

    /**
     * DTO <-> Entity transformer
     */
    private final Transformer transformer;

    @Inject
    public SalesFormResource(SalesFormService service, Transformer transformer) {
        this.transformer = transformer;
        this.service = service;

        SalesForm salesForm = new SalesForm();
        salesForm.setMaterialsNote("ffff");
        salesForm.setCustomerNote("aaaa");
        salesForm.setPaintingOperationNote("bbbb");
        service.saveSalesForm(salesForm);
    }


    /**
     * Returns all the existing cities
     *
     * @return fff
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SalesFormDTO> findCities() {
        return service.findSalesForms().stream().map((salesForm) -> transformer.transform(salesForm, SalesFormDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Saves new sales form instance
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveCity(SalesFormDTO salesFormDTO) {
        service.saveSalesForm(transformer.untransform(salesFormDTO, SalesForm.class));
    }

    /**
     * Returns sales form with specified identifier
     *
     * @return ff
     */
    @Path("/{salesFormId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCityById(@PathParam("salesFormId") final String cityId) {
        if (!NumberUtils.isNumber(cityId)) {
            return BAD_REQUEST;
        }

        Optional<SalesForm> salesForm = service.findSalesFormById(NumberUtils.toInt(cityId));
        if (!salesForm.isPresent()) {
            return NOT_FOUND;
        }
        return ok(transformer.transform(salesForm.get(), SalesFormDTO.class));
    }
}