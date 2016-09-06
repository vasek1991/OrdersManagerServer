package com.metall_a.orders_manager.app.service.impl;

import com.metall_a.orders_manager.app.infra.util.CommonUtil;
import com.metall_a.orders_manager.app.model.entity.base.User;
import com.metall_a.orders_manager.app.service.interfaces.UserService;

import java.util.ArrayList;
import java.util.List;


/**
 * Default implementation of the {@link UserService}
 *
 * @author Vasiliy Kononenko
 */
public class UserServiceImpl implements UserService {
    /**
     * Internal list of users
     */
    private final List<User> users;

    public UserServiceImpl() {
        users = new ArrayList<>();
    }

    @Override
    public List<User> findUser() {
        return CommonUtil.getSafeList(users);
    }

    @Override
    public void saveUser(User user) {
        if (!users.contains(user)) {
            users.add(user);
        }
    }
}