package com.metall_a.orders_manager.app.model.entity.order;

import com.metall_a.orders_manager.app.model.entity.base.AbstractEntity;
import com.metall_a.orders_manager.app.model.entity.enums.Materials;
import com.metall_a.orders_manager.app.model.entity.enums.MetalCutting;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Class that stores some initial information about order
 *
 * @author Kononenko Vasiliy
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Table(name = "PURCHASE_REQUEST")
@Entity
public class PurchaseRequest extends AbstractEntity {
    @NotNull
    @Size(min = 2, max = 30)
    @Column(name = "CUSTOMER_NAME", length = 30)
    private String customerName;
    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "CUSTOMER_PHONE_NUMBER", length = 15)
    private String customerPhoneNumber;
    @Column(name = "CUSTOMER_NOTE", length = 250)
    private String customerNote;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "MATERIALS")
    private Materials materials;
    @Column(name = "MATERIALS_NOTE", length = 250)
    private String materialsNote;
    @Column(name = "DRAWING_AVAILABILITY")
    private boolean drawingAvailability;
    @Column(name = "DXF_FILES")
    private boolean dxfFiles;
    @Column(name = "DRAWINGS_NOTE", length = 250)
    private String drawingsNote;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "METAL_CUTTING")
    private MetalCutting metalCutting;
    @Column(name = "METAL_CUTTING_NOTE", length = 250)
    private String metalCuttingNote;
    @Column(name = "WELDING_AND_LOCKSMITH_OPERATIONS")
    private boolean weldingAndLocksmithOperations;
    @Column(name = "WELDING_AND_LOCKSMITH_OPERATIONS_NOTE", length = 250)
    private String weldingAndLocksmithOperationsNote;
    @Column(name = "PAINTING_OPERATION")
    private boolean paintingOperation;
    @Column(name = "PAINTING_COLOR", length = 30)
    private String paintingColor;
    @Column(name = "PAINTING_OPERATION_NOTE", length = 250)
    private String paintingOperationNote;
    @Column(name = "QUANTITY")
    private int quantity;
    @Column(name = "QUANTITY_NOTE", length = 250)
    private String quantityNote;
}