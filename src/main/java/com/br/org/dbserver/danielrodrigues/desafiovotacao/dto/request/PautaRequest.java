package com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PautaRequest(
        @NotBlank(message = "o nome não pode estar em branco")
        @Size(min = 10, max = 20, message = "o nome deve conter entre {min} e {max}")
        String nome,
        @NotBlank(message = "a descrição não pode estar em branco")
        @Size(min = 30, max = 100, message = "a descrição deve conter entre {min} e {max}")
        String descricao
) {
}
