package com.metall_a.orders_manager.app.rest.service;

import com.metall_a.orders_manager.app.model.entity.order.SalesForm;
import com.metall_a.orders_manager.app.rest.dto.SalesFormDTO;
import com.metall_a.orders_manager.app.rest.service.base.BaseResource;
import com.metall_a.orders_manager.app.service.impl.SalesFormServiceImpl;
import com.metall_a.orders_manager.app.service.model_interfaces.SalesFormService;
import com.metall_a.orders_manager.app.service.transform.Transformer;
import com.metall_a.orders_manager.app.service.transform.impl.SimpleDTOTransformer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
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

    public SalesFormResource() {
        transformer = new SimpleDTOTransformer();
        service = new SalesFormServiceImpl();
        SalesForm salesForm = new SalesForm();
        salesForm.setMaterialsNote("ffff");
        salesForm.setCustomerNote("aaaa");
        salesForm.setPaintingOperationNote("bbbb");
        service.saveSalesForm(salesForm);
    }


    /**
     * Returns all the existing cities
     *
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SalesFormDTO> findCities() {
        return service.findSalesForms().stream().map((salesForm) -> transformer.transform(salesForm, SalesFormDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Saves new city instance
     *
     * @return fff ddd
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveCity(SalesFormDTO salesFormDTO) {
        service.saveSalesForm(transformer.untransform(salesFormDTO, SalesForm.class));
    }

    /*@Path("/{cityId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    *//**
     * Returns city with specified identifier
     * @return
     *//*
    public Response findCityById(@PathParam("cityId") final String cityId) {
        if (!NumberUtils.isNumber(cityId)) {
            return BAD_REQUEST;
        }

        Optional<City> city = service.findCitiyById(NumberUtils.toInt(cityId));
        if (!city.isPresent()) {
            return NOT_FOUND;
        }
        return ok(transformer.transform(city.get(), CityDTO.class));
    }*/
}