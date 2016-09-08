package com.metall_a.orders_manager.app.service.interfaces;

import com.metall_a.orders_manager.app.model.entity.person.Account;

import java.util.List;

/**
 * Entry point to perform operations
 * over person entities
 *
 * @author Vasiliy Kononenko
 */
public interface UserService {

    /**
     * Returns list of users
     *
     * @return list of users
     */
    List<Account> findUser();

    /**
     * Saves specified person instance
     *
     * @param user object
     */
    void saveUser(Account user);
}