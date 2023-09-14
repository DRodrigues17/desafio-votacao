package com.br.org.dbserver.danielrodrigues.desafiovotacao.stubs;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.PautaRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.PautaResponse;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.Pauta;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.enums.SituacaoPauta;

public class PautaStub {

    public static Pauta gerarPauta() {
        return Pauta
                .builder()
                .nome("uso de uniforme")
                .descricao("nessa pauta decidiremos se é necessário ou não o uso de uniforme no home office")
                .build();
    }

    public static PautaRequest gerarRequest() {
        return new PautaRequest("uso de uniforme",
                "nessa pauta decidiremos se é necessário ou não o uso de uniforme no home office");
    }

    public static PautaRequest gerarRequestInvalido() {
        return new PautaRequest("uniforme",
                "   ");
    }

    public static PautaResponse gerarResponse() {
        return
                PautaResponse
                        .builder()
                        .id(17)
                        .nome("uso de uniforme")
                        .descricao("nessa pauta decidiremos se é necessário ou não o uso de uniforme no home office")
                        .situacao(SituacaoPauta.PARA_VOTAR)
                        .build();
    }
}
