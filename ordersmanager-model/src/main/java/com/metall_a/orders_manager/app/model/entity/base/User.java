package com.metall_a.orders_manager.app.model.entity.base;

import lombok.*;

/**
 * User class for registration and authentication
 *
 * @author Vasiliy Kononenko
 */

@Builder
@ToString
@Getter
@Setter
@EqualsAndHashCode(doNotUseGetters = true, of = {"id"})
public class User {
    /**
     * Unique entity identifier
     */
    private int id;
    @NonNull
    private String name;
    @NonNull
    private String lastName;
    @NonNull
    private String email;
    @NonNull
    private String phoneNumber;
    @NonNull
    private String userName;
    @NonNull
    private String password;
    private int position;
}