package com.metall_a.orders_manager.app.model.entity.order;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Customer  information of {@link SalesForm}
 *
 * @author Vasiliy Kononenko
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Customer {

    public Customer() {
    }

    String name;
    String phoneNumber;
}