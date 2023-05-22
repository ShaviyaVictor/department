package com.shavic.department.exception.handler;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Class responsible for handling all Exceptions
 *
 */
@RestControllerAdvice
@ResponseStatus
public class GlobalRestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {
}
