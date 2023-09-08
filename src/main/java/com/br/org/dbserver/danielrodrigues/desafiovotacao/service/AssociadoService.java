package com.br.org.dbserver.danielrodrigues.desafiovotacao.service;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.mapper.AssociadoMapper;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.AssociadoRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.AssociadoResponse;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.Associado;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.repository.AssociadoRepository;

import java.util.NoSuchElementException;

public class AssociadoService {

    AssociadoRepository repository;

    public AssociadoResponse cadastrarAssociado(AssociadoRequest request){
        Associado associado = AssociadoMapper.gerarAssociado(request);

        return AssociadoMapper.gerarResponse(repository.save(associado));
    }

    public Associado buscarAssociado(Integer idAssociado){
        return repository.findById(idAssociado)
                .orElseThrow(() -> new NoSuchElementException("Associado não Encontrado"));
    }
}
