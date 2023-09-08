package com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.enums.Decisao;
import lombok.Builder;

@Builder
public record VotoResponse(
        Integer idAssociado,
        Integer idSessao,
        Decisao decisao
) {
}
