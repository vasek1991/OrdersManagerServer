package com.metall_a.orders_manager.app.config;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;

/**
 * Registers DI bindings
 *
 * @author Kononenko Vasiliy
 */
public class ComponentFeature implements Feature {

    @Override
    public boolean configure(final FeatureContext context) {
        context.register(new ComponentBinder());
        return true;
    }
}