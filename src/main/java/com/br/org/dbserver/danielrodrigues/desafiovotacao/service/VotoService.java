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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class VotoService {
    private final VotoRepository votoRepository;
    private final AssociadoService associadoService;
    private final SessaoService sessaoService;

    @Transactional
    public VotoResponse votar(VotoRequest request) {
        Associado associado = associadoService.buscarAssociado(request.cpfAssociado());
        SessaoDeVoto sessao = sessaoService.buscarSessaoNoBanco(request.idSessao());

        Voto voto = VotoMapper.gerarVoto(request, associado, sessao);
        fazerValidacoes(associado, sessao);

        return VotoMapper.gerarResponse(votoRepository.save(voto));
    }

    private void fazerValidacoes(Associado associado, SessaoDeVoto sessao) {

        if (votoRepository.existsByAssociadoAndSessao(associado, sessao)) {
            throw new AssociadoJaVotouException();
        } else if (LocalDateTime.now().isAfter(sessao.getHoraDeFechamento())) {
            throw new SessaoEncerradaException(sessao.getId());
        }
    }


}
