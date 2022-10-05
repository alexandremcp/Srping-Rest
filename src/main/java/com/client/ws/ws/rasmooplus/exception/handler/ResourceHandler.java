package com.client.ws.ws.rasmooplus.exception.handler;

import com.client.ws.ws.rasmooplus.dto.error.ErrorResponseDto;
import com.client.ws.ws.rasmooplus.exception.BadRequestException;
import com.client.ws.ws.rasmooplus.exception.NotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ResourceHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDto> notFoundException(NotFoundException n) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponseDto.builder()
                .message(n.getMessage())
                .httpStatus(HttpStatus.NOT_FOUND)
                .statusCode(HttpStatus.NOT_FOUND.value())
                .build());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponseDto> badRequestException(BadRequestException b) {
        String errorMessage = b.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponseDto.builder()
                .message(b.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> badRequestException(MethodArgumentNotValidException m) {

        Map<String, String> messages = new HashMap<>();
        m.getBindingResult().getFieldErrors().forEach(error -> {
            String field = ((FieldError) error).getField();
            String defaultMessage = error.getDefaultMessage();
            messages.put(field, defaultMessage);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponseDto.builder()
                .message(Arrays.toString(messages.entrySet().toArray()))
                .httpStatus(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .build());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponseDto> badRequestException(DataIntegrityViolationException d) {
        String errorMessage = d.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponseDto.builder()
                .message(d.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .build());
    }

}

/*
@RestControllerAdvice
=====================

O RestControllerAdvice Permite que se centralize as ExceptionHandlers,
    ou seja, que se centralize o tratamento de exceções.
O formato de retorno é JSON definido no ErrorResponseDto.

O BAD_REQUEST é retornado quando o cliente envia uma requisição inválida, por exemplo quando o cliente envia um JSON inválido.
O NOT_FOUND é retornado quando o cliente tenta acessar um recurso que não existe, por exemplo um ID que não existe.

MethodArgumentNotValidException --> Essa classe é uma exceção que é lançada quando um argumento anotado com @Valid falha na validação.
    getBindingResult --> Retorna um objeto BindingResult que contém os erros de validação.
    getFieldErrors --> Retorna uma lista de FieldError que contém os erros de validação.
    FieldError --> Retorna o nome do campo que falhou na validação e a mensagem de erro.
*/