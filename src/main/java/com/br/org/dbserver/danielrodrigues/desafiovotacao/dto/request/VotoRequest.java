package com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.enums.Decisao;
import jakarta.validation.constraints.NotBlank;

public record VotoRequest(

        @NotBlank
        Integer idAssociado,
        @NotBlank
        Integer idSessao,
        @NotBlank
        Decisao decisao
) {
}
