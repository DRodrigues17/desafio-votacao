package com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Optional;

public record SessaoRequest(
        @NotNull
        Integer idPauta,
        Optional<LocalDateTime> horaDeFechamento
) {
}
