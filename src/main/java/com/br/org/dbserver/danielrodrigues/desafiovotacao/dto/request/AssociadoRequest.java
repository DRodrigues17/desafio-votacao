package com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request;

import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record AssociadoRequest(
        @CPF(message = "cpf inválido")
        String cpf,
        @Size(min = 10, max = 50, message = "o nome deve ter entre {min} e {max} caracteres")
        String nome
) {
}
