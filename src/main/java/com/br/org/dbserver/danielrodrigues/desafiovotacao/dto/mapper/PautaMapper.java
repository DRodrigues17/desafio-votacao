package com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.mapper;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.PautaRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.PautaResponse;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.Pauta;
import org.springframework.stereotype.Component;

@Component
public interface PautaMapper {
    static Pauta gerarPauta(PautaRequest request) {
        return Pauta.builder()
                .nome(request.nome())
                .descricao(request.descricao())
                .build();
    }

    static PautaResponse gerarResponse(Pauta pauta) {
        return PautaResponse.builder()
                .id(pauta.getId())
                .nome(pauta.getNome())
                .descricao(pauta.getDescricao())
                .situacao(pauta.getSituacao())
                .build();
    }

}
