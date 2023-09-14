package com.br.org.dbserver.danielrodrigues.desafiovotacao.exception;

public class ObjetoNaoEncontradoException extends RuntimeException {
    public ObjetoNaoEncontradoException(String objeto) {
        super(objeto + " não encontrado/a");
    }
}
