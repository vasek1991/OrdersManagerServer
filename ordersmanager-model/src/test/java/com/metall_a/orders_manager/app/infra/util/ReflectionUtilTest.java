package com.metall_a.orders_manager.app.infra.util;

import com.metall_a.orders_manager.app.infra.exeption.ConfigurationException;
import com.metall_a.orders_manager.app.infra.exeption.flow.InvalidParameterException;
import com.metall_a.orders_manager.app.infra.util.annotation.Ignore;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Verifies functionality of the {@link ReflectionUtil} unit
 *
 * @author Kononenko Vasiliy
 */
public class ReflectionUtilTest {
    @Test
    public void createInstanceSuccess() {
        Object value = ReflectionUtil.createInstance(Source.class);
        assertNotNull(value);
    }

    @Test(expected = ConfigurationException.class)
    public void createInstanceFailure() {
        ReflectionUtil.createInstance(Restricted.class);
    }

    @Test
    public void findSimilarFieldsSuccess() {
        List<String> fields = ReflectionUtil.findSimilarFields(Source.class,
                Destination.class);
        assertNotNull(fields);
        assertTrue(fields.contains("value"));
    }

    @Test
    public void copyFieldsSuccess() {
        Source src = new Source();
        src.setValue(10);
        Destination dest = new Destination();
        List<String> fields = ReflectionUtil.findSimilarFields(src.getClass(), dest.getClass());

        ReflectionUtil.copyFields(src, dest, fields);
        assertEquals(dest.getValue(), 10);
    }

    @Test
    public void copyFindSimilarFieldsWithIgnoreSuccess() {
        List<String> fields = ReflectionUtil.findSimilarFields(Source.class, Destination.class);
        assertFalse(fields.contains("ignored"));
    }

    @Test
    public void copyFindSimilarFieldsForStaticAndFinalSuccess() {
        List<String> fields = ReflectionUtil.findSimilarFields(Source.class, Destination.class);
        assertFalse(fields.contains("staticField"));
        assertFalse(fields.contains("finalField"));
    }

    @Test
    public void copyFindSimilarFieldsForBaseFieldSuccess() {
        List<String> fields = ReflectionUtil.findSimilarFields(Source.class, Destination.class);
        assertTrue(fields.contains("baseField"));
    }

    @Test(expected = InvalidParameterException.class)
    public void copyFieldsDestinationNullFailure() {
        Source src = new Source();
        ReflectionUtil.copyFields(src, null, Collections.emptyList());
    }
}

class BaseSource {
    private int baseField;
}

class BaseDestination {
    private int baseField;
}

class Source extends BaseSource {
    private int value;
    private String text;
    @Ignore
    private int ignored = 2;
    private static int staticField;
    private final int finalField = 0;

    void setValue(int value) {
        this.value = value;
    }
}

class Destination extends BaseDestination {
    private int value;
    private int ignored;
    private int staticField;
    private int finalField = 0;

    int getValue() {
        return value;
    }
}

class Restricted {
    public Restricted(int value) {

    }
}