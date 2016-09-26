package com.metall_a.orders_manager.app.infra.util;

import com.metall_a.orders_manager.app.infra.exeption.ConfigurationException;
import com.metall_a.orders_manager.app.infra.util.annotation.Ignore;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
            List<Field> fields = getFields(clz1);
            List<String> targetFields = getFields(clz2).stream()
                    .filter(field -> !field.isAnnotationPresent(Ignore.class))
                    .map(Field::getName)
                    .collect(Collectors.toList());
            return fields.stream()
                    .filter(field -> !field.isAnnotationPresent(Ignore.class))
                    .filter(field -> !Modifier.isStatic(field.getModifiers())
                            && !Modifier.isFinal(field.getModifiers()))
                    .map(Field::getName)
                    .filter(targetFields::contains)
                    .collect(Collectors.toList());
        } catch (SecurityException ex) {
            throw new ConfigurationException(ex);
        }
    }

    /**
     * Returns all declared fields of the specified classes and all superclasses
     *
     * @param cls some class
     * @return list of fields
     */
    private static List<Field> getFields(Class<?> cls) {
        List<Field> fields = new ArrayList<>();
        while (cls != null) {
            fields.addAll(Arrays.asList(cls.getDeclaredFields()));
            cls = cls.getSuperclass();
        }
        return fields;
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
                Field fld = getField(src.getClass(), field);
                // Skip unknown fields
                if (fld != null) {
                    fld.setAccessible(true);
                    Object value = fld.get(src);

                    Field fldDest = getField(dest.getClass(), field);

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

    /**
     * Returns class field by its name. This method supports base classes as
     * well
     *
     * @param clz  some class
     * @param name some name of class
     * @return field
     */
    private static <T> Field getField(final Class<T> clz, final String name) {
        Class<?> current = clz;
        while (current != null) {
            try {
                return current.getDeclaredField(name);
            } catch (NoSuchFieldException | SecurityException e) {
                current = current.getSuperclass();
            }
        }
        throw new ConfigurationException("No field " + name + " in the class " + clz);
    }
}