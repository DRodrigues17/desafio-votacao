package com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.Voto;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record SessaoComResultadoResponse(
        Integer idSessao,
        LocalDateTime horaDeAbertura,
        LocalDateTime horaDeFechamento,
        List<Voto> votos,
        int numeroDeVotos,
        PautaResponse pauta,
        boolean encerrada
) {
}
