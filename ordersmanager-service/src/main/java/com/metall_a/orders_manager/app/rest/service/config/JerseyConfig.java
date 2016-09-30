package com.metall_a.orders_manager.app.rest.service.config;

import com.metall_a.orders_manager.app.config.ComponentFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * REST web-service configuration for Jersey
 *
 * @author Kononenko Vasiliy
 */
@ApplicationPath("api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        super(ComponentFeature.class);
        packages("com.metall_a.orders_manager.app.rest");
    }
}