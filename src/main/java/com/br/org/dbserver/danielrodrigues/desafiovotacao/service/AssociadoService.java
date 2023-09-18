package com.br.org.dbserver.danielrodrigues.desafiovotacao.service;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.mapper.AssociadoMapper;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.AssociadoRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.AssociadoResponse;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.exception.ObjetoNaoEncontradoException;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.Associado;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.repository.AssociadoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssociadoService {
    private final AssociadoRepository repository;

    @Transactional
    public AssociadoResponse cadastrarAssociado(AssociadoRequest request) {
        Associado associado = AssociadoMapper.gerarAssociado(request);

        return AssociadoMapper.gerarResponse(repository.save(associado));
    }

    public Associado buscarAssociado(String cpfAssociado) {
        return repository.findByCpf(cpfAssociado)
                .orElseThrow(() -> new ObjetoNaoEncontradoException("Associado/a " + cpfAssociado));
    }
}
