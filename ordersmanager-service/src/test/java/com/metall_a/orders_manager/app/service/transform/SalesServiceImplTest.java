package com.metall_a.orders_manager.app.service.transform;

import com.metall_a.orders_manager.app.model.entity.order.SalesForm;
import com.metall_a.orders_manager.app.service.impl.SalesFormServiceImpl;
import com.metall_a.orders_manager.app.service.model_interfaces.SalesFormService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    public void testSaveNewCitySuccess() {
        SalesForm salesForm = new SalesForm();
        salesForm.setMaterialsNote("param");
        service.saveSalesForm(salesForm);

        List<SalesForm> cities = service.findSalesForms();
        assertEquals(cities.size(), 1);
        assertEquals(cities.get(0).getMaterialsNote(), "param");
    }
}