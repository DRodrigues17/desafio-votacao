package com.br.org.dbserver.danielrodrigues.desafiovotacao.service;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.mapper.PautaMapper;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.PautaRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.PautaResponse;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.exception.ObjetoNaoEncontradoException;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.Pauta;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.enums.SituacaoPauta;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.repository.PautaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PautaService {
    private final PautaRepository repository;
    private final PautaMapper mapper;

    @Transactional
    public PautaResponse cadastrarPauta(PautaRequest request) {
        return mapper.gerarResponse(repository.save(mapper.gerarPauta(request)));
    }

    public PautaResponse buscarPauta(Integer idPauta) {
        return mapper
                .gerarResponse(buscarPautaNoBanco(idPauta));
    }

    @Transactional
    public void alterarSituacaoDaPauta(Integer idPauta, SituacaoPauta situacao) {
        Pauta pauta = buscarPautaNoBanco(idPauta);
        pauta.setSituacao(situacao);
        repository.save(pauta);
    }

    private Pauta buscarPautaNoBanco(Integer idPauta) {
        return repository.findById(idPauta).orElseThrow(() -> new ObjetoNaoEncontradoException("Pauta " + idPauta));
    }

}
