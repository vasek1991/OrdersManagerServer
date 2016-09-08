package com.metall_a.orders_manager.app.rest.dto;

import com.metall_a.orders_manager.app.model.entity.enums.Position;
import com.metall_a.orders_manager.app.model.entity.person.Account;
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
public class AccountDTO extends BaseDTO<Account> {
    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String userName;
    private String password;
    private Position position;
}