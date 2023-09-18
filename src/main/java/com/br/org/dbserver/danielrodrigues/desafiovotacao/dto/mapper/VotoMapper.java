package com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.mapper;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.VotoRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.VotoResponse;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.Associado;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.SessaoDeVoto;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.Voto;
import org.springframework.stereotype.Component;

@Component
public interface VotoMapper {
    static Voto gerarVoto(VotoRequest request, Associado associado, SessaoDeVoto sessao) {
        return Voto.builder()
                .associado(associado)
                .sessao(sessao)
                .decisao(request.decisao())
                .build();
    }

    static VotoResponse gerarResponse(Voto voto) {
        return VotoResponse.builder()
                .cpfAssociado(voto.getAssociado().getCpf())
                .idSessao(voto.getSessao().getId())
                .decisao(voto.getDecisao())
                .build();
    }
}
