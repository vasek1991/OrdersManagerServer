package com.metall_a.orders_manager.app.model.entity.person;

import com.metall_a.orders_manager.app.model.entity.base.AbstractEntity;
import com.metall_a.orders_manager.app.model.entity.enums.Position;
import lombok.*;

import javax.persistence.*;

/**
 * Account class for registration and authentication
 *
 * @author Vasiliy Kononenko
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(doNotUseGetters = true, callSuper = true)
@NoArgsConstructor
@Table(name = "ACCOUNT")
@Entity
public class Account extends AbstractEntity {
    @Column(name = "NAME", length = 30, nullable = false)
    private String name;
    @Column(name = "LAST_NAME", length = 30, nullable = false)
    private String lastName;
    @Column(name = "EMAIL", length = 50, nullable = false)
    private String email;
    @Column(name = "PHONE_NUMBER", length = 15, nullable = false)
    private String phoneNumber;
    @Column(name = "USER_NAME", length = 30, nullable = false)
    private String userName;
    @Column(name = "PASSWORD", length = 20, nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "POSITION")
    private Position position;
}