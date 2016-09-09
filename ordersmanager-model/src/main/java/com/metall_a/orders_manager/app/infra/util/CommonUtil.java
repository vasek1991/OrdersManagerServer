package com.metall_a.orders_manager.app.infra.util;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Contains utility functions of the general purpose
 *
 * @author Vasiliy Kononenko
 */
public class CommonUtil {
    /**
     * Returns not-null unmodifiable copy of the source set
     *
     * @param source some set
     * @return unmodifiable list of objects
     */
    public static <T> Set<T> getSafeSet(Set<T> source) {
        return Collections.unmodifiableSet(Optional.ofNullable(source).orElse(Collections.emptySet()));
    }

    /**
     * Returns not-null unmodifiable copy of the source list
     *
     * @param source some list
     * @return unmodifiable list of objects
     */
    public static <T> List<T> getSafeList(List<T> source) {
        return Collections.unmodifiableList(Optional.ofNullable(source).orElse(Collections.emptyList()));
    }

    /**
     * Dynamically converts param into string representation using all
     * object state
     *
     * @param param Object
     * @return String
     */
    public static String toString(Object param) {
        return ReflectionToStringBuilder.toString(param,
                ToStringStyle.SHORT_PREFIX_STYLE);
    }
}