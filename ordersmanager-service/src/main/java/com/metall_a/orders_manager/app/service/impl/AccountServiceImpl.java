package com.metall_a.orders_manager.app.service.impl;

import com.metall_a.orders_manager.app.infra.util.CommonUtil;
import com.metall_a.orders_manager.app.model.entity.person.Account;
import com.metall_a.orders_manager.app.service.model_interfaces.AccountService;

import java.util.ArrayList;
import java.util.List;


/**
 * Default implementation of the {@link AccountService}
 *
 * @author Vasiliy Kononenko
 */
public class AccountServiceImpl implements AccountService {
    /**
     * Internal list of accounts
     */
    private final List<Account> accounts;
    /**
     * Auto-increment counter for entity id generation
     */
    private int counter = 0;

    public AccountServiceImpl() {
        accounts = new ArrayList<>();
    }

    @Override
    public List<Account> findAccounts() {
        return CommonUtil.getSafeList(accounts);
    }

    @Override
    public void saveAccount(Account account) {
        if (!accounts.contains(account)) {
            account.setId(++counter);
            accounts.add(account);
        }
    }

    @Override
    public void deleteAccount(final int id) {
        accounts.removeIf(account -> account.getId() == id);
    }

    @Override
    public void updateAccount(Account account) {
    }
}