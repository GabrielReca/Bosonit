package com.example.DB1JPA.infrastructure.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BeanNotFoundException  extends RuntimeException {
    public BeanNotFoundException(String message) {
        super(message);
    }
}
