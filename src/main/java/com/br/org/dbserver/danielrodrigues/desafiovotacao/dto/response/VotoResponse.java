package com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.enums.Decisao;
import lombok.Builder;

@Builder
public record VotoResponse(
        String cpfAssociado,
        Integer idSessao,
        Decisao decisao
) {
}
