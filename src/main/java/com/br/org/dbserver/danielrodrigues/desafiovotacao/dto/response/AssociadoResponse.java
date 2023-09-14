package com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response;

import lombok.Builder;

@Builder
public record AssociadoResponse (
        String cpf,
        String nome
){
}
