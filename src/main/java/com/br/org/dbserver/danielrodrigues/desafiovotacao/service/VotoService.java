package com.br.org.dbserver.danielrodrigues.desafiovotacao.service;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.mapper.VotoMapper;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.VotoRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.VotoResponse;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.exception.AssociadoJaVotouException;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.exception.SessaoEncerradaException;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.Associado;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.SessaoDeVoto;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.Voto;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.repository.VotoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotoService {
    @Autowired
    VotoRepository votoRepository;
    @Autowired
    AssociadoService associadoService;
    @Autowired
    SessaoService sessaoService;

    @Transactional
    public VotoResponse votar(VotoRequest request) {
        Associado associado = associadoService.buscarAssociado(request.idAssociado());
        SessaoDeVoto sessao = sessaoService.buscarSessaoNoBanco(request.idSessao());

        Voto voto = VotoMapper.gerarVoto(request, associado, sessao);
        fazerValidacoes(associado, sessao);

        return VotoMapper.gerarResponse(votoRepository.save(voto));
    }

    private void fazerValidacoes(Associado associado, SessaoDeVoto sessao) {

        if (votoRepository.existsByAssociadoAndSessao(associado, sessao)) {
            throw new AssociadoJaVotouException();
        } else if (sessao.isEncerrada()) {
            throw new SessaoEncerradaException(sessao.getId());
        }
    }


}
