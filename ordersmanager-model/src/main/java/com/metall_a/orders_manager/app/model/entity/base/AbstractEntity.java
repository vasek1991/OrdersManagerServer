package com.metall_a.orders_manager.app.model.entity.base;

import com.metall_a.orders_manager.app.model.entity.person.Account;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Base class for all business entities
 *
 * @author Kononenko Vasiliy
 */
@Getter
@Setter
@EqualsAndHashCode(doNotUseGetters = true, of = {"id"})
public abstract class AbstractEntity {
    /**
     * Unique entity identifier
     */
    private int id;
    /**
     * Timestamp of entity creation
     */
    private LocalDateTime createdAt;

    /**
     * Timestamp of entity last modification
     */
    private LocalDateTime modifiedAt;
    /**
     * Person who created specific entity
     */
    private Account createdBy;

    /**
     * Last person who modified entity
     */
    private Account modifiedBy;
}