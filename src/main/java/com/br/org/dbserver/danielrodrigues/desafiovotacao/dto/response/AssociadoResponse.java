package com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response;

import lombok.Builder;

@Builder
public record AssociadoResponse (
        Long cpf,
        String nome
){
}
