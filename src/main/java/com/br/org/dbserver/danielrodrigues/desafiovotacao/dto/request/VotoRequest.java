package com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.enums.Decisao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VotoRequest(

        @NotBlank(message = "é necessário um associado para votar e ele não pode estar em branco")
        String cpfAssociado,
        @NotNull(message = "é necessário identificar a sessão de voto")
        Integer idSessao,
        Decisao decisao
) {
}
