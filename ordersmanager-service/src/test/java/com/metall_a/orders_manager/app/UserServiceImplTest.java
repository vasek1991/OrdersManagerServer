package com.metall_a.orders_manager.app;

import com.metall_a.orders_manager.app.model.entity.base.User;
import com.metall_a.orders_manager.app.model.entity.enums.Position;
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
        List<User> users = service.findUser();
        assertTrue(users.isEmpty());
    }

    @Test
    public void testSaveNewCitySuccess() {
        User user = User.builder().id(1).name("Jon").lastName("Morrison").email("jonmorrison@gmail.com")
                .userName("morrison").phoneNumber("111111").password("123456").position(Position.DIRECTOR).build();
        service.saveUser(user);

        List<User> cities = service.findUser();
        assertEquals(cities.size(), 1);
        assertEquals(cities.get(0).getName(), "Jon");
    }
}