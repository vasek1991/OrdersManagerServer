package com.metall_a.orders_manager.app.service.transform;

import com.metall_a.orders_manager.app.model.entity.base.AbstractEntity;
import com.metall_a.orders_manager.app.rest.dto.base.BaseDTO;

/**
 * Represents transformation engine to convert business entities
 * into DTO objects
 *
 * @author Kononenko Vasiliy
 */
public interface Transformer {

    /**
     * Converts specified entity into DTO object
     *
     * @param entity some entity extends {@link AbstractEntity}
     * @param clz    some class extends {@link BaseDTO}
     * @return object extends {@link BaseDTO}
     */
    <T extends AbstractEntity, P extends BaseDTO<T>> P transform(T entity, Class<P> clz);

    /**
     * Converts specified DTO object into business entity
     *
     * @param dto some dto {@link BaseDTO}
     * @param clz some class extends {@link AbstractEntity}
     * @return object extends {@link AbstractEntity}
     */
    <T extends AbstractEntity, P extends BaseDTO<T>> T untransform(P dto, Class<T> clz);
}