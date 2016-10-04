package com.metall_a.orders_manager.app.rest.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Global Jersey handler that catches any Exception-based errors
 *
 * @author Kononenko Vasiliy
 */
@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Exception> {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private final Response SERVER_ERROR;

    GlobalExceptionHandler() {
        SERVER_ERROR = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

    @Override
    public Response toResponse(Exception ex) {
        LOGGER.error(ex.getMessage(), ex);
        return SERVER_ERROR;
    }
}