package com.metall_a.orders_manager.app.infra.exeption;

import com.metall_a.orders_manager.app.infra.exeption.base.AppException;

/**
 * Signals about exceptional cases in the application logic
 *
 * @author Kononenko Vasiliy
 */
public class FlowException extends AppException {

    private static final long serialVersionUID = -3445445919305073766L;

    public FlowException(String message, Throwable cause) {
        super(message, cause);
    }

    public FlowException(String message) {
        super(message);
    }
}