package com.br.org.dbserver.danielrodrigues.desafiovotacao.stubs;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.AssociadoRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.Associado;

public interface AssociadoStub {

    static Associado gerarAssociado() {
        return Associado
                .builder()
                .cpf("13093250064")
                .nome("Daniel Rodrigues")
                .build();
    }

    static AssociadoRequest gerarRequest() {
        return new AssociadoRequest("13093250064", "Daniel Rodrigues");
    }

}
