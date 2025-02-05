package com.scofield.que_aula_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandle {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErroResponse> handleRuntimeException(RuntimeException ex){
        ErroResponse erro = new ErroResponse(HttpStatus.BAD_REQUEST.value(), "Erro: " + ex.getMessage());
        return ResponseEntity.badRequest().body(erro);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErroResponse> handleIllegalArgumentException(IllegalArgumentException ex){
        ErroResponse erro = new ErroResponse(HttpStatus.BAD_REQUEST.value(), "Parâmetros inválidos: " + ex.getMessage());
        return ResponseEntity.badRequest().body(erro);
    }
}
