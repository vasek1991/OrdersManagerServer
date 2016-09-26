package com.metall_a.orders_manager.app.rest.service;

import com.metall_a.orders_manager.app.rest.service.config.JerseyConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.core.Application;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


/**
 * {@link UserResourceTest} is integration test that verifies
 * {@link AccountResource}
 *
 * @author Kononenko Vasiliy
 */
public class UserResourceTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new JerseyConfig();
    }

    @Test
    public void testFindUsersSuccess() {
        List<?> users = target("users").request().get(List.class);
        assertNotNull(users);
        assertTrue(users.contains("user1"));
        assertTrue(users.contains("user2"));
    }
}