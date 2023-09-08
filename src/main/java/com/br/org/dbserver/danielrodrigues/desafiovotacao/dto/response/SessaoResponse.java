package com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record SessaoResponse(

        Integer idSessao,
        LocalDateTime horaDeAbertura,
        LocalDateTime horaDeFechamento,
        PautaResponse pauta,
        boolean encerrada
) {
}
