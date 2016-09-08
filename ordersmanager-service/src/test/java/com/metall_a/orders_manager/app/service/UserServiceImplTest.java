package com.metall_a.orders_manager.app.service;

import com.metall_a.orders_manager.app.model.entity.enums.Position;
import com.metall_a.orders_manager.app.model.entity.person.Account;
import com.metall_a.orders_manager.app.service.impl.UserServiceImpl;
import com.metall_a.orders_manager.app.service.interfaces.UserService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Contain unit-tests for {@link UserServiceImpl}
 *
 * @author Vasiliy Kononenko
 */
public class UserServiceImplTest {
    private UserService service;

    @Before
    public void setup() {
        service = new UserServiceImpl();
    }

    @Test
    public void testNoDataReturnedAtStart() {
        List<Account> users = service.findUser();
        assertTrue(users.isEmpty());
    }

    @Test
    public void testSaveNewCitySuccess() {
        Account account = new Account();
        account.setId(1);
        account.setName("Jon");
        account.setLastName("Morrison");
        account.setEmail("jonmorrison@gmail.com");
        account.setUserName("morrison");
        account.setPhoneNumber("111111");
        account.setPassword("123456");
        account.setPosition(Position.DIRECTOR);
        service.saveUser(account);

        List<Account> cities = service.findUser();
        assertEquals(cities.size(), 1);
        assertEquals(cities.get(0).getName(), "Jon");
        assertEquals(cities.get(0).getLastName(), "Morrison");
        assertEquals(cities.get(0).getEmail(), "jonmorrison@gmail.com");
        assertEquals(cities.get(0).getUserName(), "morrison");
        assertEquals(cities.get(0).getPhoneNumber(), "111111");
        assertEquals(cities.get(0).getPassword(), "123456");
        assertEquals(cities.get(0).getPosition(), Position.DIRECTOR);
    }
}