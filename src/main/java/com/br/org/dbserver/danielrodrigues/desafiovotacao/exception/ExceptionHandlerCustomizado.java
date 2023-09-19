package com.br.org.dbserver.danielrodrigues.desafiovotacao.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerCustomizado {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErroDTO> tratarErrosInesperados(RuntimeException erroInesperado) {
        return construirEntidadeDeErro("erro inesperado: " + erroInesperado.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroDTO> tratarViolacaoDeConstraint(MethodArgumentNotValidException e) {
        List<String> detalhesDosErros = new ArrayList<>();
        for (ObjectError erro : e.getBindingResult().getAllErrors()) {
            detalhesDosErros.add(erro.getDefaultMessage());
        }

        return construirEntidadeDeErro("Alguns dados não foram preenchidos corretamente, revise-os e tente novamente " + detalhesDosErros
                , HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(DecisaoInvalidaException.class)
    public ResponseEntity<ErroDTO> tratarViolacaoDeConstraint(DecisaoInvalidaException e) {
        return construirEntidadeDeErro(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }


    @ExceptionHandler(AssociadoJaVotouException.class)
    public ResponseEntity<ErroDTO> tratarAssociadoTentandoVotarMaisDeUmaVez(AssociadoJaVotouException e) {
        return construirEntidadeDeErro(e.getMessage(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(SessaoEncerradaException.class)
    public ResponseEntity<ErroDTO> tratarSessaoJaEncerrada(SessaoEncerradaException e) {
        return construirEntidadeDeErro(e.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(ObjetoNaoEncontradoException.class)
    public ResponseEntity<ErroDTO> tratarSessaoJaEncerrada(ObjetoNaoEncontradoException e) {
        return construirEntidadeDeErro(e.getMessage(), HttpStatus.NOT_FOUND);
    }


    private ResponseEntity<ErroDTO> construirEntidadeDeErro(String mensagem, HttpStatus statusCode) {
        ErroDTO corpoDoErro = new ErroDTO(mensagem, LocalDateTime.now());
        log.info("erro tratado " + corpoDoErro);
        return new ResponseEntity<>(corpoDoErro, statusCode);
    }
}
