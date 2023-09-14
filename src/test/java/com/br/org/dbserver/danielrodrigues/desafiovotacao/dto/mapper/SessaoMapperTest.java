package com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.mapper;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.SessaoRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.SessaoDeVoto;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.stubs.SessaoStub;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SessaoMapperTest {

    @Test
    void deveGerarSessaoComCurtoTempoDeFechamentoCasoNaoSejaPassadoPeloUsuarioNaHoraDoCadastro() {
        SessaoRequest request = SessaoStub.gerarRequestSemHoraDeFechamentoDefinido();
        SessaoDeVoto sessaoDeVoto = SessaoMapper.gerarSessao(request);
        assertEquals(LocalDateTime.now().plusMinutes(1), sessaoDeVoto.getHoraDeFechamento());
    }
}