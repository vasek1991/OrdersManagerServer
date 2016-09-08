package com.metall_a.orders_manager.app.model.search.criteria;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * Filtering criteria for search person
 *
 * @author Kononenko Vasiliy
 */

@Getter
@Setter
public class AccountCriteria {

    private String accountName;

    public AccountCriteria() {
    }

    /**
     * Returns filtering criteria to search users that
     * contains specified person name parameter
     *
     * @param accountName some string
     * @return person criteria
     */
    public static AccountCriteria byAccountName(String accountName) {
        return new AccountCriteria(accountName);
    }


    private AccountCriteria(final String userName) {
        this.accountName = Objects.requireNonNull(userName);
    }
}