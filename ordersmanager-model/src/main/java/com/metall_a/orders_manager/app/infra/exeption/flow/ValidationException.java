package com.metall_a.orders_manager.app.infra.exeption.flow;

import com.metall_a.orders_manager.app.infra.exeption.FlowException;

import javax.validation.ConstraintViolation;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * {@link ValidationException} is raised when attribute values of the
 * object model violates business rules or restrictions
 *
 * @author Kononenko Vasiliy
 */
public class ValidationException extends FlowException {

    private static final long serialVersionUID = -3099207233835041032L;

    public <T> ValidationException(String message, Set<ConstraintViolation<T>> constraints) {
        super(message + ":" + constraints.stream()
                .map(constraint -> constraint.getPropertyPath() + ":" + constraint.getMessage())
                .collect(Collectors.joining(",")));
    }
}