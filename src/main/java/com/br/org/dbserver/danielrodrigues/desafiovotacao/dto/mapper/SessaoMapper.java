package com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.mapper;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.SessaoRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.PautaResponse;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.SessaoComResultadoResponse;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.SessaoResponse;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.SessaoDeVoto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public interface SessaoMapper {

    static SessaoDeVoto gerarSessao(SessaoRequest request) {
        if (request.horaDeFechamento().isEmpty()) {
            return SessaoDeVoto.builder()
                    .horaDeAbertura(LocalDateTime.now())
                    .horaDeFechamento(LocalDateTime.now().plusMinutes(1))
                    .idDaPauta(request.idPauta())
                    .build();
        }
        return SessaoDeVoto.builder()
                .horaDeAbertura(LocalDateTime.now())
                .idDaPauta(request.idPauta())
                .horaDeFechamento(request.horaDeFechamento().get())
                .build();
    }

    static SessaoResponse gerarResponse(SessaoDeVoto sessao, PautaResponse pauta) {
        return SessaoResponse.builder()
                .idSessao(sessao.getId())
                .horaDeAbertura(sessao.getHoraDeAbertura())
                .horaDeFechamento(sessao.getHoraDeFechamento())
                .pauta(pauta)
                .build();
    }

    static SessaoComResultadoResponse gerarResponseComResultados(SessaoDeVoto sessao, PautaResponse pauta) {
        return SessaoComResultadoResponse.builder()
                .idSessao(sessao.getId())
                .horaDeAbertura(sessao.getHoraDeAbertura())
                .horaDeFechamento(sessao.getHoraDeFechamento())
                .votos(sessao.getVotos())
                .numeroDeVotos(sessao.getVotos().size())
                .pauta(pauta)
                .build();
    }
}
