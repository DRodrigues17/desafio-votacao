package com.br.org.dbserver.danielrodrigues.desafiovotacao.stubs;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.VotoRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.VotoResponse;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.Voto;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.enums.Decisao;

public class VotoStub {
    public static Voto gerarVotoPositivo() {
        return Voto
                .builder()
                .associado(AssociadoStub.gerarAssociado())
                .sessao(SessaoStub.gerarSessao())
                .decisao(Decisao.SIM)
                .build();
    }

    public static Voto gerarVotoNegativo() {
        return Voto
                .builder()
                .associado(AssociadoStub.gerarAssociado())
                .sessao(SessaoStub.gerarSessao())
                .decisao(Decisao.NAO)
                .build();
    }

    public static VotoRequest gerarRequestPositivo() {
        return new VotoRequest(1, 1, Decisao.SIM);
    }

    public static VotoRequest gerarRequestNegativo() {
        return new VotoRequest(1, 1, Decisao.NAO);
    }

    public static VotoRequest gerarRequestInvalido() {
        return new VotoRequest(2, 3, Decisao.SIM);
    }

    public static VotoResponse gerarResponse() {
        return VotoResponse
                .builder()
                .idAssociado(1)
                .idSessao(1)
                .decisao(Decisao.SIM)
                .build();
    }
}
