package com.example.springrest.exception.exceptionhandler;

import com.example.springrest.exception.CustomerAlreadyExistsException;
import com.example.springrest.exception.CustomerExceptionResponse;
import com.example.springrest.exception.NoSuchCustomerExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // global exception handler
public class CustomerExceptionHandler {

    // Tell Spring that this method is responsible for handling the NoSuchCustomerExistsException
    @ExceptionHandler(value = {NoSuchCustomerExistsException.class})
    public ResponseEntity<Object> handleNoSuchException(NoSuchCustomerExistsException e)
    {
        // create payload containing exception details
        CustomerExceptionResponse customerExceptionResponse =  new CustomerExceptionResponse(e.getMessage(), e.getCause(), HttpStatus.BAD_REQUEST);

        // return response entity
        return new ResponseEntity<>(customerExceptionResponse, HttpStatus.BAD_REQUEST);

    }

    // Tell Spring that this method is responsible for handling the CustomerAlreadyExistsException
    @ExceptionHandler(value = {CustomerAlreadyExistsException.class})
    public ResponseEntity<Object> handleAlreadyExistsException(CustomerAlreadyExistsException e)
    {
        // create payload containing exception details
        CustomerExceptionResponse customerExceptionResponse =  new CustomerExceptionResponse(e.getMessage(), e.getCause(), HttpStatus.BAD_REQUEST);

        // return response entity
        return new ResponseEntity<>(customerExceptionResponse, HttpStatus.BAD_REQUEST);

    }

}
