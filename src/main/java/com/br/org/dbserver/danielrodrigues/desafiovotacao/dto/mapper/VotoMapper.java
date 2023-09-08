package com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.mapper;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.VotoRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.VotoResponse;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.Associado;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.SessaoDeVoto;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.Voto;

public class VotoMapper {
    public static Voto gerarVoto(VotoRequest request, Associado associado, SessaoDeVoto sessao){
        return Voto.builder()
                .associado(associado)
                .sessao(sessao)
                .decisao(request.decisao())
                .build();
    }

    public static VotoResponse gerarResponse(Voto voto){
        return VotoResponse.builder()
                .idAssociado(voto.getAssociado().getId())
                .idSessao(voto.getSessao().getId())
                .decisao(voto.getDecisao())
                .build();
    }
}
