package com.example.springrest.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class CustomerExceptionResponse {

    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;

}
