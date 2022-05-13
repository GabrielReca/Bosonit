package com.example.cors.infrastructure.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandlerCORS extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BeanNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(BeanNotFoundException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), HttpStatus.NOT_ACCEPTABLE.getReasonPhrase());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(UnprocessableException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(UnprocessableException ux, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ux.getMessage(), HttpStatus.NOT_ACCEPTABLE.getReasonPhrase());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
    }

}

