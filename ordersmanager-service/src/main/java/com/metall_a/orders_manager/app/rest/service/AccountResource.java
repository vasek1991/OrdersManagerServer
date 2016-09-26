package com.metall_a.orders_manager.app.rest.service;

import jersey.repackaged.com.google.common.collect.Lists;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * {@link AccountResource} is REST web-service that handles person-related requests
 *
 * @author Vasiliy Kononenko
 */
@Path("users")
public class AccountResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> findUsers() {
        return Lists.newArrayList("user1", "user2");
    }
}