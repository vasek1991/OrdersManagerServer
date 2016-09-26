package com.metall_a.orders_manager.app.rest.dto;

import com.metall_a.orders_manager.app.model.entity.enums.Materials;
import com.metall_a.orders_manager.app.model.entity.enums.MetalCutting;
import com.metall_a.orders_manager.app.model.entity.order.SalesForm;
import com.metall_a.orders_manager.app.rest.dto.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Holds person state for the client-server communication
 *
 * @author Vasiliy Kononenko
 */
@Getter
@Setter
public class SalesFormDTO extends BaseDTO<SalesForm> {
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
}