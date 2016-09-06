package com.metall_a.orders_manager.app.infra.exeption.flow;

import com.metall_a.orders_manager.app.infra.exeption.FlowException;

/**
 * Signals that incorrect parameter was passed to method/constructor
 *
 * @author Kononenko Vasiliy
 */
public class InvalidParameterException extends FlowException {

    private static final long serialVersionUID = -1164422470653612957L;

    public InvalidParameterException(String message) {
        super(message);
    }
}