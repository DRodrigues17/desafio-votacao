package com.br.org.dbserver.danielrodrigues.desafiovotacao.stubs;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.SessaoRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.SessaoComResultadoResponse;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.SessaoResponse;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.SessaoDeVoto;

import java.time.LocalDateTime;
import java.util.List;
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

    public static SessaoRequest gerarRequestInvalido() {
        return new SessaoRequest(3, Optional.of(LocalDateTime.now()));
    }

    public static SessaoResponse gerarResponse() {
        return SessaoResponse
                .builder()
                .idSessao(1)
                .horaDeAbertura(LocalDateTime.now())
                .horaDeFechamento(LocalDateTime.now().plusMinutes(15))
                .pauta(PautaStub.gerarResponse())
                .build();
    }

    public static SessaoComResultadoResponse gerarResponseComResultado() {
        return SessaoComResultadoResponse
                .builder()
                .idSessao(1)
                .horaDeAbertura(LocalDateTime.now().minusMinutes(15))
                .horaDeFechamento(LocalDateTime.now())
                .pauta(PautaStub.gerarResponse())
                .votos(List.of(VotoStub.gerarVotoPositivo()))
                .numeroDeVotos(1)
                .encerrada(true)
                .build();
    }
}
