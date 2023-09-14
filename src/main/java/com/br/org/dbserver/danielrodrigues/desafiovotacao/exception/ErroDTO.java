package com.br.org.dbserver.danielrodrigues.desafiovotacao.exception;

import java.time.LocalDateTime;

public record ErroDTO(
        String mensagem,
        LocalDateTime horaDoErro
) {
}
