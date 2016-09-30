package com.metall_a.orders_manager.app.rest.dto.base;

import com.metall_a.orders_manager.app.model.entity.base.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * Base class for all DTO classes
 *
 * @author Kononenko VAsiliy
 */
@Getter
@Setter
public abstract class BaseDTO<T extends AbstractEntity> {
    /**
     * Unique entity identifier
     */
    private long id;

    /**
     * Should be overridden in the derived classes if additional transformation
     * logic domain model -> DTO is needed.
     * Overridden methods should call super.transform()
     */
    public void transform(T t) {
        id = t.getId();
    }

    /**
     * Should be overridden in the derived classes if additional transformation
     * logic DTO -> domain model is needed
     */
    public T untransform(T t) {
        t.setId(getId());
        return t;
    }
}