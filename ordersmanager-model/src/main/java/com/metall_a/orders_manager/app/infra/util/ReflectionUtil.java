package com.metall_a.orders_manager.app.infra.util;

import com.metall_a.orders_manager.app.infra.exeption.ConfigurationException;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Contains reflection-related utility operations
 *
 * @author Vasiliy Kononenko
 */
public class ReflectionUtil {
    private ReflectionUtil() {
    }

    /**
     * Creates an instance of the specified class. This method throws unchecked
     * exception if creation fails
     *
     * @param clz some class
     * @return generic type
     * @throws ConfigurationException exception
     */
    public static <T> T createInstance(Class<T> clz)
            throws ConfigurationException {
        try {
            return clz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new ConfigurationException(e);
        }
    }

    /**
     * Returns list of fields with identical names irregardles of their
     * modifiers
     *
     * @param clz1 some class1
     * @param clz2 some class2
     * @return list of strings
     */
    public static List<String> findSimilarFields(Class<?> clz1, Class<?> clz2)
            throws ConfigurationException {
        try {
            Field[] fields = clz1.getDeclaredFields();
            List<String> targetFields = Stream.of(clz2.getDeclaredFields())
                    .map(Field::getName)
                    .collect(Collectors.toList());
            return Stream.of(fields)
                    .map(Field::getName)
                    .filter(targetFields::contains)
                    .collect(Collectors.toList());
        } catch (SecurityException ex) {
            throw new ConfigurationException(ex);
        }
    }

    /**
     * Copy specified fields values from source to destination objects
     *
     * @param src    object src
     * @param dest   object dest
     * @param fields list of strings fields
     */
    public static void copyFields(Object src, Object dest, List<String> fields)
            throws ConfigurationException {
        Checks.checkParameter(src != null, "Source object is not initialized");
        Checks.checkParameter(dest != null, "Destination object is not initialized");
        try {
            for (String field : fields) {
                Field fld = src.getClass().getDeclaredField(field);
                // Skip unknown fields
                if (fld != null) {
                    fld.setAccessible(true);
                    Object value = fld.get(src);

                    Field fldDest = dest.getClass().getDeclaredField(field);

                    if (fldDest != null) {
                        fldDest.setAccessible(true);
                        fldDest.set(dest, value);
                    }
                }
            }
        } catch (SecurityException | ReflectiveOperationException
                | IllegalArgumentException ex) {
            throw new ConfigurationException(ex);
        }
    }
}