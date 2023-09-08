package com.br.org.dbserver.danielrodrigues.desafiovotacao.service;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.mapper.SessaoMapper;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.mapper.VotoMapper;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.VotoRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.VotoResponse;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.Associado;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.SessaoDeVoto;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.Voto;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.repository.VotoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VotoService {

    VotoRepository votoRepository;
    AssociadoService associadoService;
    SessaoService sessaoService;

    @Transactional
    public VotoResponse votar(VotoRequest request) {
        Associado associado = associadoService.buscarAssociado(request.idAssociado());
        SessaoDeVoto sessao = SessaoMapper.gerarSessao(sessaoService.buscarSessao(request.idSessao()));

        Voto voto = VotoMapper.gerarVoto(request, associado, sessao);
        fazerValidacoes(voto);

        return VotoMapper.gerarResponse(votoRepository.save(voto));
    }

    private void fazerValidacoes(Voto voto) {

        if (votoRepository.findAll().contains(voto)){
            throw new RuntimeException("Esse associado já votou para essa pauta, logo não pode votar novamente");
        }else if (voto.getSessao().isEncerrada()) {
            throw new RuntimeException("Sessão já encerrada, logo não é mais permitido votar");
        }
    }


}
