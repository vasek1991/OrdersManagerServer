package com.metall_a.orders_manager.app.model.search.criteria;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * Filtering criteria for search user
 *
 * @author Kononenko Vasiliy
 */

@Getter
@Setter
public class UserCriteria {

    private String userName;

    public UserCriteria() {
    }

    /**
     * Returns filtering criteria to search users that
     * contains specified user name parameter
     *
     * @param userName some string
     * @return user criteria
     */
    public static UserCriteria byUserName(String userName) {
        return new UserCriteria(userName);
    }


    private UserCriteria(final String userName) {
        this.userName = Objects.requireNonNull(userName);
    }
}