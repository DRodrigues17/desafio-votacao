package com.br.org.dbserver.danielrodrigues.desafiovotacao.exception;

public class DecisaoInvalidaException extends RuntimeException {

    public DecisaoInvalidaException(String causa) {
        super("Decisão inválida: " + causa);
    }
}
