package com.metall_a.orders_manager.app.rest.service;

import com.metall_a.orders_manager.app.model.entity.enums.Materials;
import com.metall_a.orders_manager.app.model.entity.enums.MetalCutting;
import com.metall_a.orders_manager.app.model.entity.enums.State;
import com.metall_a.orders_manager.app.model.entity.order.Order;
import com.metall_a.orders_manager.app.model.entity.order.PurchaseRequest;
import com.metall_a.orders_manager.app.rest.dto.OrderDTO;
import com.metall_a.orders_manager.app.rest.service.base.BaseResource;
import com.metall_a.orders_manager.app.service.service_interfaces.OrderService;
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
 * {@link OrderResource} is REST web-service that handles orders department-related requests
 *
 * @author Vasiliy Kononenko
 */
@Path("orders")
public class OrderResource extends BaseResource {
    /**
     * Underlying source of data
     */
    private final OrderService service;

    /**
     * DTO <-> Entity transformer
     */
    private final Transformer transformer;

    @Inject
    public OrderResource(OrderService service, Transformer transformer) {
        this.transformer = transformer;
        this.service = service;

        Order order = new Order();
        PurchaseRequest purchaseRequest = new PurchaseRequest();
        purchaseRequest.setCustomerName("fff");
        purchaseRequest.setMaterials(Materials.INCLUDED_IN_PRICE);
        purchaseRequest.setCustomerPhoneNumber("11111");
        purchaseRequest.setMetalCutting(MetalCutting.LASER_CUTTING);
        order.setState(State.OPEN);
        order.setPurchaseRequest(purchaseRequest);
        service.saveOrder(order);
    }

    /**
     * Saves new Order instance
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveOrder(OrderDTO order) {
        service.saveOrder(transformer.untransform(order, Order.class));
    }

    /**
     * Returns all the existing Orders
     *
     * @return List of Orders
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrderDTO> findOrders() {
        return service.findOrders().stream().map((order) -> transformer.transform(order, OrderDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Returns Order with specified identifier
     *
     * @return Response
     */
    @Path("/{orderId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCityById(@PathParam("orderId") final String orderId) {
        if (!NumberUtils.isNumber(orderId)) {
            return BAD_REQUEST;
        }

        Optional<Order> order = service.findOrderById(NumberUtils.toInt(orderId));
        if (!order.isPresent()) {
            return NOT_FOUND;
        }
        return ok(transformer.transform(order.get(), OrderDTO.class));
    }
}