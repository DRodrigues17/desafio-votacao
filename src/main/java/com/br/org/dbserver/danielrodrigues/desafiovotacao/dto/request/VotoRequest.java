package com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.enums.Decisao;
import jakarta.validation.constraints.NotNull;

public record VotoRequest(

        @NotNull(message = "é necessário um associado para votar")
        Integer idAssociado,
        @NotNull(message = "é necessário identificar a sessão de voto")
        Integer idSessao,
        Decisao decisao
) {
}
