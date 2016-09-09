package com.metall_a.orders_manager.app.service.transform.impl;

import com.metall_a.orders_manager.app.infra.util.Checks;
import com.metall_a.orders_manager.app.infra.util.CommonUtil;
import com.metall_a.orders_manager.app.infra.util.ReflectionUtil;
import com.metall_a.orders_manager.app.model.entity.base.AbstractEntity;
import com.metall_a.orders_manager.app.rest.dto.base.BaseDTO;
import com.metall_a.orders_manager.app.service.transform.Transformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Default transformation engine that uses reflection to transform objects
 *
 * @author Morenets
 */
public class SimpleDTOTransformer implements Transformer {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(SimpleDTOTransformer.class);

    @Override
    public <T extends AbstractEntity, P extends BaseDTO<T>> P transform(
            final T entity, final Class<P> clz) {
        checkParams(entity, clz);

        P dto = ReflectionUtil.createInstance(clz);
        // Now just copy all the similar fields
        ReflectionUtil.copyFields(entity, dto,
                ReflectionUtil.findSimilarFields(entity.getClass(), clz));
        dto.transform(entity);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("SimpleDTOTransformer.transform: {} DTO object",
                    CommonUtil.toString(dto));
        }
        return dto;
    }

    private void checkParams(final Object param, final Class<?> clz) {
        Checks.checkParameter(param != null, "Source transformation object is not initialized");
        Checks.checkParameter(clz != null,
                "No class is defined for transformation");
    }

    @Override
    public <T extends AbstractEntity, P extends BaseDTO<T>> T untransform(
            final P dto, final Class<T> clz) {
        checkParams(dto, clz);

        T entity = ReflectionUtil.createInstance(clz);

        ReflectionUtil.copyFields(dto, entity,
                ReflectionUtil.findSimilarFields(dto.getClass(), clz));
        dto.untransform(entity);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("SimpleDTOTransformer.transform: {} entity",
                    CommonUtil.toString(entity));
        }
        return entity;
    }
}
