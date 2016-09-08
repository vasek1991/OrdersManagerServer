package com.metall_a.orders_manager.app.model.entity.person;

import com.metall_a.orders_manager.app.model.entity.base.AbstractEntity;
import com.metall_a.orders_manager.app.model.entity.enums.Position;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Account class for registration and authentication
 *
 * @author Vasiliy Kononenko
 */
@ToString
@Getter
@Setter
public class Account extends AbstractEntity {
    public Account() {
    }

    public Account(String name) {
        this.name = name;
    }

    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String userName;
    private String password;
    private Position position;
}