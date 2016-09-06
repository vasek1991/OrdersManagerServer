package com.metall_a.orders_manager.app.model.entity.enums;

import lombok.Getter;

/**
 * Enum with user positions
 *
 * @author Ihor Bilous
 */
@Getter
public enum Position {
    DIRECTOR(1),
    DEPUTY(2),
    SALES_DEP(3),
    LOGISTICS_DEP(4),
    ACCOUNTING_DEP(5),
    CUTTING_BENDING_DEP(6),
    WELDING_LOCKSMITH_DEP(7),
    PAINTING_DEP(8);

    private final int value;

    Position(int value) {
        this.value = value;
    }
}