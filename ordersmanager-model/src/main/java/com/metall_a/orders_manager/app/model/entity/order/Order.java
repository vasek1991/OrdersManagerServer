package com.metall_a.orders_manager.app.model.entity.order;

import com.metall_a.orders_manager.app.model.entity.base.AbstractEntity;
import com.metall_a.orders_manager.app.model.entity.enums.State;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * That class contains all information about order
 *
 * @author Kononenko Vasiliy
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Table(name = "ORDERS")
@Entity
public class Order extends AbstractEntity {
    @Valid
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "purchase_Request_ID")
    private PurchaseRequest purchaseRequest;
    @Valid
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "technical_Calculation_ID")
    private TechnicalCalculation technicalCalculation;
    private State state;
}