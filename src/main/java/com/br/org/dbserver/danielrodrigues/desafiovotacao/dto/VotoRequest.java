package com.br.org.dbserver.danielrodrigues.desafiovotacao.dto;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.enums.Decisao;

public record VotoRequest(
        int idAssociado,
        Decisao decisao
) {
}
