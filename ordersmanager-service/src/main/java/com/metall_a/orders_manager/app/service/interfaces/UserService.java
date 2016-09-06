package com.metall_a.orders_manager.app.service.interfaces;

import com.metall_a.orders_manager.app.model.entity.base.User;

import java.util.List;

/**
 * Entry point to perform operations
 * over user entities
 *
 * @author Vasiliy Kononenko
 */
public interface UserService {

    /**
     * Returns list of users
     *
     * @return list of users
     */
    List<User> findUser();

    /**
     * Saves specified user instance
     *
     * @param user object
     */
    void saveUser(User user);
}