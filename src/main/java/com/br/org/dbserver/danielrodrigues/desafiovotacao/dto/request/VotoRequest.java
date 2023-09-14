package com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.enums.Decisao;
import jakarta.validation.constraints.NotNull;

public record VotoRequest(

        @NotNull
        Integer idAssociado,
        @NotNull
        Integer idSessao,
        @NotNull
        Decisao decisao
) {
}
