package com.br.org.dbserver.danielrodrigues.desafiovotacao.stubs;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.VotoRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.Voto;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.enums.Decisao;

public interface VotoStub {
    static Voto gerarVotoPositivo() {
        return Voto
                .builder()
                .associado(AssociadoStub.gerarAssociado())
                .sessao(SessaoStub.gerarSessao())
                .decisao(Decisao.SIM)
                .build();
    }

    static Voto gerarVotoNegativo() {
        return Voto
                .builder()
                .associado(AssociadoStub.gerarAssociado())
                .sessao(SessaoStub.gerarSessao())
                .decisao(Decisao.NAO)
                .build();
    }

    static VotoRequest gerarRequestPositivo() {
        return new VotoRequest("13093250064", 1, Decisao.SIM);
    }

    static VotoRequest gerarRequestNegativo() {
        return new VotoRequest("13093250064", 1, Decisao.NAO);
    }

}
