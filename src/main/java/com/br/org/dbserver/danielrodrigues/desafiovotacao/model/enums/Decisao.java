package com.br.org.dbserver.danielrodrigues.desafiovotacao.model.enums;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.exception.DecisaoInvalidaException;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum Decisao {
    SIM,
    NAO;

    @JsonCreator
    public static Decisao gerarDecisaoApartirDoValor(String valor) {
        if (valor.equalsIgnoreCase(NAO.name()) || valor.equalsIgnoreCase("Não")) {
            return NAO;
        } else if (valor.equalsIgnoreCase(SIM.name())) {
            return SIM;
        }

        throw new DecisaoInvalidaException(valor);
    }
}
