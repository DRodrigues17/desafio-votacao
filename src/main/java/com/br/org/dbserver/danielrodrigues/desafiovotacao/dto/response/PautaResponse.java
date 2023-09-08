package com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.enums.SituacaoPauta;
import lombok.Builder;

@Builder
public record PautaResponse(

        Integer id,
        String nome,
        String descricao,
        SituacaoPauta situacao
) {
}
