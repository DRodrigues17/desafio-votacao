package com.br.org.dbserver.danielrodrigues.desafiovotacao.model.enums;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.exception.DecisaoInvalidaException;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum Decisao {
    SIM,
    NAO;

    @JsonCreator
    public static Decisao gerarDecisaoApartirDoValor(String valor) {
        for (Decisao decisao : Decisao.values()) {
            if (decisao.name().equalsIgnoreCase(valor)) {
                return decisao;
            }
        }
        throw new DecisaoInvalidaException(valor);
    }
}
