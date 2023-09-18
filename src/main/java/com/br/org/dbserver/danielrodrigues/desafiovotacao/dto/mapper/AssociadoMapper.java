package com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.mapper;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.AssociadoRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.AssociadoResponse;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.Associado;
import org.springframework.stereotype.Component;

@Component
public interface AssociadoMapper {

    static Associado gerarAssociado(AssociadoRequest request) {
        return Associado
                .builder()
                .cpf(request.cpf())
                .nome(request.nome())
                .build();
    }

    static AssociadoResponse gerarResponse(Associado associado) {
        return AssociadoResponse
                .builder()
                .cpf(associado.getCpf())
                .nome(associado.getNome())
                .build();
    }
}
