package com.metall_a.orders_manager.app.rest.exception;

import com.metall_a.orders_manager.app.infra.exeption.flow.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Jersey exception handler that catches validation errors
 *
 * @author Kononenko Vasiliy
 */
@Provider
public class ValidationExceptionHandler implements ExceptionMapper<ValidationException> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationExceptionHandler.class);

    @Override
    public Response toResponse(ValidationException ex) {
        LOGGER.error(ex.getMessage(), ex);
        return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
    }
}