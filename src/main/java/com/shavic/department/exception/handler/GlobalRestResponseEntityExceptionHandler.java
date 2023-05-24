package com.shavic.department.exception.handler;

import com.shavic.department.entity.ErrorMessage;
import com.shavic.department.exception.DepartmentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotFoundException exception, WebRequest webRequest) {

//        response class
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());

//        Object message = ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);

    }

}
