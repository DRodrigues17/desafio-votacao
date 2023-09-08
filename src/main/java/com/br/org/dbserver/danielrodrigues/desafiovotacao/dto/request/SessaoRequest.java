package com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.Optional;

public record SessaoRequest(
        @NotBlank
        int idPauta,
        Optional<LocalDateTime> horaDeFechamento
) {
}
