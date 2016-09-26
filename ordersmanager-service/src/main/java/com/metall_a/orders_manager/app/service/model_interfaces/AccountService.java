package com.metall_a.orders_manager.app.service.model_interfaces;

import com.metall_a.orders_manager.app.model.entity.person.Account;

import java.util.List;

/**
 * Entry point to perform operations
 * over person entities
 *
 * @author Vasiliy Kononenko
 */
public interface AccountService {

    /**
     * Returns list of accounts
     *
     * @return list of accounts
     */
    List<Account> findAccounts();

    /**
     * Saves specified person instance
     *
     * @param account Account
     */
    void saveAccount(Account account);

    /**
     * Deletes specified person instance by id
     *
     * @param id int
     */
    void deleteAccount(int id);

    /**
     * Updates specified person instance
     *
     * @param account Account
     */
    void updateAccount(Account account);
}