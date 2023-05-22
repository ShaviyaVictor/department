package com.shavic.department.exception;

/**
 * Custom exception that can be thrown when user tries to retrieve from the DB an object that does not exist
 * Spring_Docs:
 *      https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc
 *      https://www.geeksforgeeks.org/spring-boot-exception-handling/
 *
 */
public class DepartmentNotFoundException extends Exception {
    public DepartmentNotFoundException() {
        super();
    }

    public DepartmentNotFoundException(String message) {
        super(message);
    }

    public DepartmentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentNotFoundException(Throwable cause) {
        super(cause);
    }

    protected DepartmentNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
