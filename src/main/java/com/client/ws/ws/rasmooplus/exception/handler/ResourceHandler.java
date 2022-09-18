package com.client.ws.ws.rasmooplus.exception.handler;

import com.client.ws.ws.rasmooplus.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice       // Permite que se centralize o tratamento de exceções
public class ResourceHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> notFoundException(NotFoundException n) {
        String errorMessage = n.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
/*
@RestControllerAdvice
Permite que se centralize as ExceptionHandlers, ou seja, que se centralize o tratamento de exceções.
 */