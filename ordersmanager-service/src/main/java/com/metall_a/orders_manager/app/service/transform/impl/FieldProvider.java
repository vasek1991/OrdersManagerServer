package com.metall_a.orders_manager.app.service.transform.impl;

import com.metall_a.orders_manager.app.infra.util.ReflectionUtil;

import java.util.List;

/**
 * Base functionality of the field preparation
 *
 * @author Kononenko Vasiliy
 */
class FieldProvider {
    public List<String> getFieldNames(Class<?> source, Class<?> dest) {
        return ReflectionUtil.findSimilarFields(source, dest);
    }
}