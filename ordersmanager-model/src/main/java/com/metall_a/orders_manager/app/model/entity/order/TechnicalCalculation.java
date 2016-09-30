package com.metall_a.orders_manager.app.model.entity.order;

import com.metall_a.orders_manager.app.infra.util.CommonUtil;
import com.metall_a.orders_manager.app.model.entity.base.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Class that stores some calculated information about order
 *
 * @author Kononenko Vasiliy
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(doNotUseGetters = true, callSuper = true)
@NoArgsConstructor
@Table(name = "TECHNICAL_CALCULATION")
@Entity
public class TechnicalCalculation extends AbstractEntity {
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "technicalCalculation", orphanRemoval = true)
    private Set<Purchase> purchases;
    @Column(name = "MATERIALS_COST", precision = 10, scale = 3)
    private double materialsCost;
    @Column(name = "PURCHASES_COST", precision = 10, scale = 3)
    private double purchasesCost;
    @Column(name = "TIME_TO_DEVELOP", length = 100)
    private String timeToDevelop;
    @Column(name = "DEVELOPMENT_COST", precision = 10, scale = 3)
    private double developmentCost;
    //private List<CuttingType> cuttingTypes;
    @Column(name = "CUTTING_COST", precision = 10, scale = 3)
    private double cuttingCost;
    @Column(name = "TIME_TO_CUTTING", length = 100)
    private String timeToCutting;
    @Column(name = "BENDING_COST", precision = 10, scale = 3)
    private double bendingCost;
    @Column(name = "TIME_TO_BENDING", length = 100)
    private String timeToBending;
    @Column(name = "WELDING_AND_LOCKSMITH_COST", precision = 10, scale = 3)
    private double weldingAndLocksmithCost;
    @Column(name = "TIME_TO_WELDING_AND_LOCKSMITH", length = 100)
    private String timeToWeldingAndLocksmith;
    @Column(name = "PAINTING_QUADRATURE", precision = 10, scale = 3)
    private double paintingQuadrature;
    @Column(name = "PAINTING_COST", precision = 10, scale = 3)
    private double paintingCost;
    @Column(name = "TIME_TO_PAINTING", length = 100)
    private String timeToPainting;
    @Column(name = "LEAD_TIME", length = 100)
    private String leadTime;
    @Column(name = "TOTAL_PRODUCT_COST", precision = 10, scale = 3)
    private double totalProductCost;
    @Column(name = "TOTAL_ORDER_COST", precision = 10, scale = 3)
    private double totalOrderCost;

    public Set<Purchase> getPurchases() {
        return CommonUtil.getSafeSet(purchases);
    }

    /**
     * Adds specified purchase to the purchases list
     *
     * @param name     String
     * @param quantity int
     * @param price    double
     */
    public Purchase addPurchase(final String name, final int quantity, final double price) {
        if (purchases == null) {
            purchases = new HashSet<>();
        }
        Purchase purchase = new Purchase(this, name, quantity, price);
        purchases.add(purchase);
        return purchase;
    }

    /**
     * Removes specified purchase from purchase list
     *
     * @param purchase Purchase
     */
    public void removePurchase(Purchase purchase) {
        Objects.requireNonNull(purchase, "station parameter is not initialized");
        if (purchases == null) {
            return;
        }
        purchases.remove(purchase);
    }
}