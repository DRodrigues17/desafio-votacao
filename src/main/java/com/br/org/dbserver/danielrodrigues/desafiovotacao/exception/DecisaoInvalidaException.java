package com.br.org.dbserver.danielrodrigues.desafiovotacao.exception;

public class DecisaoInvalidaException extends RuntimeException {
    public DecisaoInvalidaException(String decisao) {
        super("Decisão inválida: " + decisao);
    }
}
