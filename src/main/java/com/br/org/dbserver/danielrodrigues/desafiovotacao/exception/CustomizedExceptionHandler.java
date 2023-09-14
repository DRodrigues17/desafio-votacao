package com.br.org.dbserver.danielrodrigues.desafiovotacao.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class CustomizedExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErroDTO> tratarErrosInesperados(RuntimeException erroInesperado) {
        return construirEntidadeDeErro("erro inesperado na nossa API: " + erroInesperado.getMessage(), HttpStatus.BAD_REQUEST);
    }


    private ResponseEntity<ErroDTO> construirEntidadeDeErro(String mensagem, HttpStatus statusCode) {
        ErroDTO corpoDoErro = new ErroDTO(mensagem, LocalDateTime.now());

        return new ResponseEntity<>(corpoDoErro, statusCode);
    }
}
