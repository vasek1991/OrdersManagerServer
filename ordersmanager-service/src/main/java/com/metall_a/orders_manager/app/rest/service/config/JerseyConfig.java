package com.metall_a.orders_manager.app.rest.service.config;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * REST web-service configuration for Jersey
 *
 * @author Vasiliy Kononenko
 */
@ApplicationPath("api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("com.metall_a.orders_manager.app.rest");
    }
}