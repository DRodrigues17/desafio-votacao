package com.br.org.dbserver.danielrodrigues.desafiovotacao.service;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.mapper.SessaoMapper;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.SessaoRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.SessaoComResultadoResponse;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.SessaoResponse;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.SessaoDeVoto;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.repository.SessaoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class SessaoService {

    private SessaoRepository sessaoRepository;
    private PautaService pautaService;

    @Transactional
    public SessaoResponse abrirUmaSessao(SessaoRequest sessaoRequest) {
        SessaoDeVoto sesao = sessaoRepository.save(SessaoMapper.gerarSessao(sessaoRequest));

        return SessaoMapper.gerarResponse(sesao, pautaService.buscarPauta(sessaoRequest.idPauta()));
    }

    public SessaoResponse buscarSessao(Integer idSessao) {
        SessaoDeVoto sessao = buscarSessaoNoBanco(idSessao);

        return SessaoMapper.gerarResponse(sessao, pautaService.buscarPauta(sessao.getIdDaPauta()));
    }

    public SessaoComResultadoResponse buscarResultadoDaVotacao(Integer idSessao){
        SessaoDeVoto sessao = buscarSessaoNoBanco(idSessao);

        return SessaoMapper.gerarResponseComResultados(sessao, pautaService.buscarPauta(sessao.getIdDaPauta()));
    }

    private SessaoDeVoto buscarSessaoNoBanco(Integer idSessao){
        return sessaoRepository.findById(idSessao)
                .orElseThrow(() -> new NoSuchElementException("Sessão não Encontrada"));
    }

}
