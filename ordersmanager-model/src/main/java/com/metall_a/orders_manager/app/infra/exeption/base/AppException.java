package com.metall_a.orders_manager.app.infra.exeption.base;

/**
 * Base class for all application-specific exceptions
 *
 * @author Kononenko Vasiliy
 */
public abstract class AppException extends RuntimeException {
    private static final long serialVersionUID = -2236867643488816347L;

    public AppException(String message) {
        super(message);
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(Throwable throwable) {
        super(throwable);
    }

}