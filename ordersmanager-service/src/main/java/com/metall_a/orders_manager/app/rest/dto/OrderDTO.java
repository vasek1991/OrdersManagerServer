package com.metall_a.orders_manager.app.rest.dto;

import com.metall_a.orders_manager.app.model.entity.enums.State;
import com.metall_a.orders_manager.app.model.entity.order.Order;
import com.metall_a.orders_manager.app.rest.dto.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Holds Order state for the client-server communication
 *
 * @author Vasiliy Kononenko
 */
@Getter
@Setter
public class OrderDTO extends BaseDTO<Order> {
    private State state;
    //private PurchaseRequest purchaseRequest;
    //private TechnicalCalculation technicalCalculation;
}