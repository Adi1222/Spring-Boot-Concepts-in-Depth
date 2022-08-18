package com.example.springrest.exception;

public class NoSuchCustomerExistsException extends RuntimeException{

    public NoSuchCustomerExistsException() {
    }

    public NoSuchCustomerExistsException(String message) {
        super(message);
    }

    public NoSuchCustomerExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
