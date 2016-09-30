package com.metall_a.orders_manager.app.model.entity.order;

import com.metall_a.orders_manager.app.model.entity.base.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

/**
 * Purchase entity for technical calculation of order
 *
 * @author Kononenko Vasiliy
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true, of = "name"/*exclude = {"price", "quantity"}*/)
@NoArgsConstructor
@Table(name = "PURCHASE")
@Entity
public class Purchase extends AbstractEntity {
    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    @JoinColumn(name = "TECHNICAL_CALCULATION_ID")
    private TechnicalCalculation technicalCalculation;
    @Column(name = "NAME", length = 10)
    private String name;
    @Column(name = "QUANTITY")
    private int quantity;
    @Column(name = "PRICE", precision = 10, scale = 3)
    private double price;

    /**
     * You shouldn't create purchase object directly. Use
     * {@link TechnicalCalculation} functionality instead
     *
     * @param technicalCalculation TechnicalCalculation
     * @param name                 String
     * @param quantity             int
     * @param price                double
     */
    public Purchase(final TechnicalCalculation technicalCalculation, final String name,
                    final int quantity, final double price) {
        this.technicalCalculation = Objects.requireNonNull(technicalCalculation);
        this.name = Objects.requireNonNull(name);
        this.quantity = quantity;
        this.price = price;
    }
}