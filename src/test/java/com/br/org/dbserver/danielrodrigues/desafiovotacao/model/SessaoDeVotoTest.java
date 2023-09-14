package com.br.org.dbserver.danielrodrigues.desafiovotacao.model;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.enums.SituacaoPauta;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.stubs.SessaoStub;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.stubs.VotoStub;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SessaoDeVotoTest {

    static Stream<Arguments> gerarDadosParaTeste() {
        return Stream.of(
                Arguments.of(List.of(VotoStub.gerarVotoNegativo(), VotoStub.gerarVotoPositivo()), SituacaoPauta.RECUSADA),
                Arguments.of(List.of(VotoStub.gerarVotoNegativo(), VotoStub.gerarVotoNegativo(), VotoStub.gerarVotoPositivo()), SituacaoPauta.RECUSADA),
                Arguments.of(List.of(VotoStub.gerarVotoNegativo(), VotoStub.gerarVotoPositivo(), VotoStub.gerarVotoPositivo()), SituacaoPauta.APROVADA)
        );
    }

    @ParameterizedTest
    @MethodSource("gerarDadosParaTeste")
    void deveRetornarSituacaoDaPautaDependendoDosVvotos(List<Voto> votos, SituacaoPauta situacaoEsperada) {
        SessaoDeVoto sessaoDeVoto = SessaoStub.gerarSessao();
        sessaoDeVoto.setVotos(votos);
        assertEquals(situacaoEsperada, sessaoDeVoto.descobrirResultadoDaVotacao());
    }
}