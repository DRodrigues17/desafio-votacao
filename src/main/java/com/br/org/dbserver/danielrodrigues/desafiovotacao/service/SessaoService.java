package com.br.org.dbserver.danielrodrigues.desafiovotacao.service;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.mapper.SessaoMapper;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.SessaoRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.SessaoComResultadoResponse;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.SessaoResponse;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.exception.ObjetoNaoEncontradoException;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.SessaoDeVoto;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.repository.SessaoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SessaoService {
    private final SessaoRepository sessaoRepository;
    private final PautaService pautaService;

    @Transactional
    public SessaoResponse abrirUmaSessao(SessaoRequest sessaoRequest) {
        SessaoDeVoto sesao = SessaoMapper.gerarSessao(sessaoRequest);

        return SessaoMapper.gerarResponse(sessaoRepository.save(sesao), pautaService.buscarPauta(sessaoRequest.idPauta()));
    }

    public SessaoComResultadoResponse buscarResultadoDaVotacao(Integer idSessao){
        SessaoDeVoto sessao = buscarSessaoNoBanco(idSessao);

        if (LocalDateTime.now().isAfter(sessao.getHoraDeFechamento())) {
            pautaService.alterarSituacaoDaPauta(sessao.getIdDaPauta(), sessao.descobrirResultadoDaVotacao());
        }

        return SessaoMapper.gerarResponseComResultados(sessao, pautaService.buscarPauta(sessao.getIdDaPauta()));
    }

    public SessaoDeVoto buscarSessaoNoBanco(Integer idSessao) {
        return sessaoRepository.findById(idSessao)
                .orElseThrow(() -> new ObjetoNaoEncontradoException("Sessão " + idSessao));
    }

}
