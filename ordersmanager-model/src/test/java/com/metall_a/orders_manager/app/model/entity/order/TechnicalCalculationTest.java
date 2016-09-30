package com.metall_a.orders_manager.app.model.entity.order;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Contains unit-tests to check functionality of {@link TechnicalCalculation} class
 *
 * @author Kononenko Vasiliy
 */
public class TechnicalCalculationTest {
    private TechnicalCalculation technicalCalculation;

    @Before
    public void setup() {
        technicalCalculation = new TechnicalCalculation();
        technicalCalculation.setBendingCost(400);
    }

    @Test
    public void testAddValidTechnicalCalculationSuccess() {
        Purchase purchase = this.technicalCalculation.addPurchase("name", 1, 44.0);

        assertTrue(containsStation(this.technicalCalculation, purchase));
        assertEquals(this.technicalCalculation, purchase.getTechnicalCalculation());
    }

    @Test(expected = NullPointerException.class)
    public void testAddTechnicalCalculationNullTransportTypeFailure() {
        technicalCalculation.addPurchase(null, 0, 0);

        assertTrue(false);
    }

    @Test
    public void testRemoveTechnicalCalculationSuccess() {
        Purchase purchase = technicalCalculation.addPurchase("name", 1, 44.0);

        technicalCalculation.removePurchase(purchase);

        assertTrue(technicalCalculation.getPurchases().isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveNullTechnicalCalculationFailure() {
        technicalCalculation.removePurchase(null);

        assertTrue(false);
    }

    private boolean containsStation(TechnicalCalculation technicalCalculation, Purchase purchase) {
        return technicalCalculation.getPurchases().contains(purchase);
    }
}