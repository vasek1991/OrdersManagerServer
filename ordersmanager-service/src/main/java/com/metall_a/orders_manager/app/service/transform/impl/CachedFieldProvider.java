package com.metall_a.orders_manager.app.service.transform.impl;

import com.metall_a.orders_manager.app.infra.util.ReflectionUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class caches field names for each transformation pair
 *
 * @author Kononenko Vasiliy
 */
class CachedFieldProvider extends FieldProvider {
    /**
     * Mapping between transformation pair(class names) and field list
     */
    private final Map<String, List<String>> cache;

    CachedFieldProvider() {
        cache = new HashMap<>();
    }

    /**
     * Returns list of similar field names for source/destination classes
     *
     * @param source some Class
     * @param dest   some Class
     * @return List of String
     */
    @Override
    public List<String> getFieldNames(Class<?> source, Class<?> dest) {
        String key = source.getSimpleName() + dest.getSimpleName();
        List<String> fields = cache.get(key);
        if (fields == null) {
            fields = ReflectionUtil.findSimilarFields(source, dest);
            cache.put(key, fields);
        }
        return fields;
    }
}