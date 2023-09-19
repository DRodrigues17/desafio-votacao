package com.br.org.dbserver.danielrodrigues.desafiovotacao.exception;

public class SessaoEncerradaException extends RuntimeException {
    public SessaoEncerradaException(Integer idSessao) {
        super("Sessão " + idSessao + " já encerrada, logo não é mais permitido votar");
    }
}
