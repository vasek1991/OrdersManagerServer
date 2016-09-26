package com.metall_a.orders_manager.app.service.transform;

import com.metall_a.orders_manager.app.model.entity.order.SalesForm;
import com.metall_a.orders_manager.app.service.impl.SalesFormServiceImpl;
import com.metall_a.orders_manager.app.service.model_interfaces.SalesFormService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Contain unit-tests for {@link SalesServiceImplTest}
 *
 * @author Kononenko Vasiliy
 */
public class SalesServiceImplTest {
    private static final int DEFAULT_CITY_ID = 1;

    private SalesFormService service;

    @Before
    public void setup() {
        service = new SalesFormServiceImpl();
    }

    @Test
    public void testNoDataReturnedAtStart() {
        List<SalesForm> salesForms = service.findSalesForms();
        assertTrue(salesForms.isEmpty());
    }

    @Test
    public void testSaveNewSalesFormSuccess() {
        SalesForm salesForm = new SalesForm();
        salesForm.setMaterialsNote("param");
        service.saveSalesForm(salesForm);

        List<SalesForm> cities = service.findSalesForms();
        assertEquals(cities.size(), 1);
        assertEquals(cities.get(0).getMaterialsNote(), "param");
    }

    @Test
    public void testFindSalesFormByIdSuccess() {
        SalesForm salesForm = new SalesForm();
        salesForm.setMaterialsNote("param");
        service.saveSalesForm(salesForm);

        Optional<SalesForm> foundSalesForm = service.findSalesFormById(DEFAULT_CITY_ID);
        assertTrue(foundSalesForm.isPresent());
        assertEquals(foundSalesForm.get().getId(), DEFAULT_CITY_ID);
    }

    @Test
    public void testFindSalesFormByIdNotFound() {
        Optional<SalesForm> foundSalesForm = service.findSalesFormById(DEFAULT_CITY_ID);
        assertFalse(foundSalesForm.isPresent());
    }
}