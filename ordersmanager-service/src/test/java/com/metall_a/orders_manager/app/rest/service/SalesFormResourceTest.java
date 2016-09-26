package com.metall_a.orders_manager.app.rest.service;

import com.metall_a.orders_manager.app.rest.dto.SalesFormDTO;
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
 * {@link SalesFormResourceTest} is integration test that verifies
 * {@link SalesFormResource}
 *
 * @author Morenets
 */
public class SalesFormResourceTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new JerseyConfig();
    }

    @Test
    public void testFindCitiesSuccess() {
        List<Map<String, String>> salesForms = target("sales-forms").request().get(List.class);
        assertNotNull(salesForms);
        assertEquals(salesForms.size(), 1);

        Map<String, String> salesForm = salesForms.get(0);
        assertEquals(salesForm.get("materialsNote"), "ffff");
        assertEquals(salesForm.get("customerNote"), "aaaa");
        assertEquals(salesForm.get("paintingOperationNote"), "bbbb");
    }

   /* @Test
    public void testFindCityByIdSuccess() {
        CityDTO city = target("cities/1").request().get(CityDTO.class);
        assertNotNull(city);
        assertEquals(city.getId(), 1);
        assertEquals(city.getName(), "Odessa");
    }*/

    /*@Test
    public void testFindCityByIdNotFound() {
        Response response = target("cities/2").request().get(Response.class);
        assertNotNull(response);
        assertEquals(response.getStatus(), Response.Status.NOT_FOUND.getStatusCode());
    }*/

    /*@Test
    public void testFindCityByIdInvalidId() {
        Response response = target("cities/aaab").request().get(Response.class);
        assertNotNull(response);
        assertEquals(response.getStatus(), Response.Status.BAD_REQUEST.getStatusCode());
    }*/

    @Test
    public void testSaveCitySuccess() {
        SalesFormDTO salesFormDTO = new SalesFormDTO();
        salesFormDTO.setMaterialsNote("gggg");
        Response response = target("sales-forms").request().post(Entity.entity(salesFormDTO, MediaType.APPLICATION_JSON));
        assertEquals(response.getStatus(), Response.Status.NO_CONTENT.getStatusCode());
    }
}