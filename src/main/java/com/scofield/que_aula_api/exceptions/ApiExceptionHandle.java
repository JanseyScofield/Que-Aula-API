package com.scofield.que_aula_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandle {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErroResponse> handleException(RuntimeException ex){
        ErroResponse erro = new ErroResponse(HttpStatus.BAD_REQUEST.value(), "Erro: " + ex.getMessage());
        return ResponseEntity.badRequest().body(erro);
    }
}
