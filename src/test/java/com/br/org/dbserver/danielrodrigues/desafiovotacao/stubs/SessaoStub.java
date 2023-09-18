package com.br.org.dbserver.danielrodrigues.desafiovotacao.stubs;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.SessaoRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.SessaoDeVoto;

import java.time.LocalDateTime;
import java.util.Optional;

public interface SessaoStub {
    static SessaoDeVoto gerarSessao() {
        return SessaoDeVoto
                .builder()
                .horaDeAbertura(LocalDateTime.now())
                .horaDeFechamento(LocalDateTime.now().plusMinutes(15))
                .idDaPauta(1)
                .build();
    }

    static SessaoDeVoto gerarSessaoComHoraDeFedchamentoNoPassado() {
        return SessaoDeVoto
                .builder()
                .horaDeAbertura(LocalDateTime.of(2023, 9, 14, 15, 12))
                .horaDeFechamento(LocalDateTime.of(2023, 9, 15, 15, 12))
                .idDaPauta(1)
                .build();
    }

    static SessaoRequest gerarRequest() {
        return new SessaoRequest(1, Optional.of(LocalDateTime.now().plusMinutes(15)));
    }

    static SessaoRequest gerarRequestSemHoraDeFechamentoDefinido() {
        return new SessaoRequest(1, Optional.empty());
    }

}
