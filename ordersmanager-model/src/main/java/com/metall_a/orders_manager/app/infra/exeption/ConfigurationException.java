package com.metall_a.orders_manager.app.infra.exeption;

import com.metall_a.orders_manager.app.infra.exeption.base.AppException;

/**
 * Signals about incorrect configuration settings/parameters
 *
 * @author Kononenko Vasiliy
 */
public class ConfigurationException extends AppException {
    private static final long serialVersionUID = 2946239328010627949L;

    public ConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigurationException(String message) {
        super(message);
    }

    public ConfigurationException(Throwable throwable) {
        super(throwable);
    }
}