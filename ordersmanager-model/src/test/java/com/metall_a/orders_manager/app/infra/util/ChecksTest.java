package com.metall_a.orders_manager.app.infra.util;

import com.metall_a.orders_manager.app.infra.exeption.flow.InvalidParameterException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Verifies functionality of {@link Checks} class
 *
 * @author Morenets
 */
public class ChecksTest {
    @Test
    public void testCheckParameterGetException() {
        try {
            Checks.checkParameter(false, "test");
            assertTrue(false);
        } catch (Exception ex) {
            assertSame(ex.getClass(), InvalidParameterException.class);
            assertEquals(ex.getMessage(), "test");
        }
    }

    @Test
    public void testCheckParameterNoException() {
        Checks.checkParameter(true, "test");
        assertTrue(true);
    }
}