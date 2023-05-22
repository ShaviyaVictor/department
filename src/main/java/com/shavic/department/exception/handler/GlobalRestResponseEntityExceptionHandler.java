package com.shavic.department.exception.handler;

import com.shavic.department.entity.ErrorMessage;
import com.shavic.department.exception.DepartmentNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Class responsible for handling all Exceptions to all controllers
 *
 */
@RestControllerAdvice
@ResponseStatus
public class GlobalRestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ErrorMessage departmentNotFoundException(DepartmentNotFoundException e, WebRequest webRequest) {

        return null;

    }

}
