package com.metall_a.orders_manager.app.rest.service;

import com.metall_a.orders_manager.app.model.entity.base.User;
import com.metall_a.orders_manager.app.model.entity.enums.Position;
import jersey.repackaged.com.google.common.collect.Lists;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * {@link UserResource} is REST web-service that handles user-related requests
 *
 * @author Vasiliy Kononenko
 */
@Path("cities")
public class UserResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> findUsers() {
        User user = User.builder().id(1).name("Jon").lastName("Morrison").email("jonmorrison@gmail.com")
                .userName("morrison").phoneNumber("4444").password("123456").position(Position.DIRECTOR).build();
        User user1 = User.builder().id(1).name("Jon").lastName("Morrison").email("jonmorrison@gmail.com")
                .userName("morrison").phoneNumber("ddddd").password("123456").position(Position.DIRECTOR).build();
        return Lists.newArrayList(user, user1);
    }
}