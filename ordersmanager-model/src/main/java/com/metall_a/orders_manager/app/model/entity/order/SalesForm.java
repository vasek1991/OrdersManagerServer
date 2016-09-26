package com.metall_a.orders_manager.app.model.entity.order;

import com.metall_a.orders_manager.app.model.entity.base.AbstractEntity;
import com.metall_a.orders_manager.app.model.entity.enums.Materials;
import com.metall_a.orders_manager.app.model.entity.enums.MetalCutting;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Class that stores some initial information about order
 *
 * @author Kononenko Vasiliy
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class SalesForm extends AbstractEntity {
    public SalesForm() {
    }

    private Customer customer;
    private String customerNote;
    private Materials materials;
    private String materialsNote;
    private boolean drawingAvailability;
    private boolean dxfFiles;
    private String drawingsNote;
    private MetalCutting metalCutting;
    private String metalCuttingNote;
    private boolean weldingAndLocksmithOperations;
    private String weldingAndLocksmithOperationsNote;
    private boolean paintingOperation;
    private String paintingColor;
    private String paintingOperationNote;
    private int quantity;
    private String quantityNote;

    /**
     * Verifies if current station matches specified criteria
     * @param criteria
     * @return
     *//*
    public boolean match(final StationCriteria criteria) {
        Objects.requireNonNull(criteria, "Station criteria is not initialized");

        if(!StringUtils.isEmpty(criteria.getName())) {
            if(!city.getName().equals(criteria.getName())) {
                return false;
            }
        }

        if(criteria.getTransportType() != null) {
            if(transportType != criteria.getTransportType()) {
                return false;
            }
        }

        return true;
    }*/
}