package com.br.org.dbserver.danielrodrigues.desafiovotacao.stubs;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.PautaRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.PautaResponse;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.Pauta;

public interface PautaStub {

    static Pauta gerarPauta() {
        return Pauta
                .builder()
                .nome("uso de uniforme")
                .descricao("nessa pauta decidiremos se é necessário ou não o uso de uniforme no home office")
                .build();
    }

    static PautaRequest gerarRequest() {
        return new PautaRequest("uso de uniforme",
                "nessa pauta decidiremos se é necessário ou não o uso de uniforme no home office");
    }

    static PautaResponse gerarResponse() {
        return PautaResponse
                .builder()
                .id(1)
                .nome("uso de uniforme")
                .descricao("nessa pauta decidiremos se é necessário ou não o uso de uniforme no home office")
                .build();
    }
}
