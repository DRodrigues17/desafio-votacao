package com.br.org.dbserver.danielrodrigues.desafiovotacao.service;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.mapper.PautaMapper;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.PautaRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.PautaResponse;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.Pauta;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.enums.SituacaoPauta;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.repository.PautaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PautaService {

    @Autowired
    PautaRepository repository;

    @Transactional
    public PautaResponse cadastrarPauta(PautaRequest request) {
        return PautaMapper.gerarResponse(repository.save(PautaMapper.gerarPauta(request)));
    }

    public PautaResponse buscarPauta(Integer idPauta) {
        return PautaMapper
                .gerarResponse(repository.findById(idPauta)
                        .orElseThrow(() -> new NoSuchElementException("Pauta não Encontrada")));
    }

    @Transactional
    public void alterarSituacaoDaPauta(Integer idPauta, SituacaoPauta situacao) {
        Pauta pauta = repository.findById(idPauta).orElseThrow(() -> new NoSuchElementException("Pauta não Encontrada"));
        pauta.setSituacao(situacao);
        repository.save(pauta);
    }

}
