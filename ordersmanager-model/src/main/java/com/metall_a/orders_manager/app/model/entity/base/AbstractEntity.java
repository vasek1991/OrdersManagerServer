package com.metall_a.orders_manager.app.model.entity.base;

import com.metall_a.orders_manager.app.model.entity.person.Account;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Base class for all business entities
 *
 * @author Kononenko Vasiliy
 */
@Getter
@Setter
@EqualsAndHashCode(doNotUseGetters = true, of = {"id"})
@MappedSuperclass
public abstract class AbstractEntity {
    public static final String FIELD_CREATED_AT = "createdAt";
    /**
     * Unique entity identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    /**
     * Timestamp of entity creation
     */
    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    /**
     * Timestamp of entity last modification
     */
    @Column(name = "MODIFIED_AT", insertable = false)
    private LocalDateTime modifiedAt;
    /**
     * Person who created specific entity
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "CREATED_BY", updatable = false)
    private Account createdBy;

    /**
     * Last person who modified entity
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "MODIFIED_BY", insertable = false)
    private Account modifiedBy;

    @PrePersist
    public void prePersist() {
        if (getId() == 0) {
            setCreatedAt(LocalDateTime.now());
        }
    }
}