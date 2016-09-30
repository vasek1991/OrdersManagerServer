package com.metall_a.orders_manager.app.rest.service;

import com.metall_a.orders_manager.app.model.entity.enums.State;
import com.metall_a.orders_manager.app.rest.dto.OrderDTO;
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
public class OrderResourceTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new JerseyConfig();
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testFindOrderSuccess() {
        List<Map<String, String>> orders = target("orders").request().get(List.class);
        assertNotNull(orders);
        assertEquals(orders.size(), 1);

        Map<String, String> order = orders.get(0);
        assertEquals(order.get("state"), State.OPEN.toString());
    }

    @Test
    public void testFindOrderByIdSuccess() {
        OrderDTO orderDTO = target("orders/1").request().get(OrderDTO.class);
        assertNotNull(orderDTO);
        assertEquals(orderDTO.getId(), 1);
        assertEquals(orderDTO.getState(), State.OPEN);
    }

    @Test
    public void testFindOrderByIdNotFound() {
        Response response = target("orders/2").request().get(Response.class);
        assertNotNull(response);
        assertEquals(response.getStatus(), Response.Status.NOT_FOUND.getStatusCode());
    }

    @Test
    public void testFindOrderByIdInvalidId() {
        Response response = target("orders/what").request().get(Response.class);
        assertNotNull(response);
        assertEquals(response.getStatus(), Response.Status.BAD_REQUEST.getStatusCode());
    }

    @Test
    public void testSaveOrderSuccess() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setState(State.OPEN);
        Response response = target("orders").request().post(Entity.entity(orderDTO, MediaType.APPLICATION_JSON));
        System.out.println(response);
        assertEquals(response.getStatus(), Response.Status.NO_CONTENT.getStatusCode());
    }
}