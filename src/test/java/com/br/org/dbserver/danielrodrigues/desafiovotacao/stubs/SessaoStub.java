package com.br.org.dbserver.danielrodrigues.desafiovotacao.stubs;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.SessaoRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.SessaoDeVoto;

import java.time.LocalDateTime;
import java.util.Optional;

public class SessaoStub {
    public static SessaoDeVoto gerarSessao() {
        return SessaoDeVoto
                .builder()
                .horaDeAbertura(LocalDateTime.now())
                .horaDeFechamento(LocalDateTime.now().plusMinutes(15))
                .idDaPauta(1)
                .build();
    }

    public static SessaoRequest gerarRequest() {
        return new SessaoRequest(1, Optional.of(LocalDateTime.now().plusMinutes(15)));
    }

    public static SessaoRequest gerarRequestSemHoraDeFechamentoDefinido() {
        return new SessaoRequest(1, Optional.empty());
    }

}
