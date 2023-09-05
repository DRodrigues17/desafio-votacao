package com.br.org.dbserver.danielrodrigues.desafiovotacao.dto;

import java.time.LocalTime;
import java.util.Optional;

public record SessaoRequest(
        int idPauta,
        Optional<LocalTime> horaDeFechamento
) {
}
