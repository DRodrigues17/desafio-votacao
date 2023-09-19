package com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record SessaoComResultadoResponse(
        Integer idSessao,
        LocalDateTime horaDeAbertura,
        LocalDateTime horaDeFechamento,
        List<VotoResponse> votos,
        int numeroDeVotos,
        PautaResponse pauta
) {
}
