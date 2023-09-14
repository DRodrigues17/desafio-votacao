package com.br.org.dbserver.danielrodrigues.desafiovotacao.exception;

public class AssociadoJaVotouException extends RuntimeException {
    public AssociadoJaVotouException() {
        super("Esse associado já votou para essa pauta, logo não pode votar novamente");
    }
}
