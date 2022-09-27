package com.client.ws.ws.rasmooplus.dto.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
public class ErrorResponseDto {
    private String message;
    private HttpStatus httpStatus;
    private Integer statusCode;
}

/*
Aqui é criado o DTO que será retornado quando ocorrer uma exceção.
Essa classe é responsável por encapsular as informações que serão retornadas quando ocorrer uma exceção
e devolver no formato definido no ErrorResponseDto no padrão JSON.
 */