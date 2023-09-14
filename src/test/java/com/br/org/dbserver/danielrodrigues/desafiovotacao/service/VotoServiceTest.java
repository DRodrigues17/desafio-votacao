package com.br.org.dbserver.danielrodrigues.desafiovotacao.service;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.mapper.VotoMapper;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.exception.AssociadoJaVotouException;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.exception.ObjetoNaoEncontradoException;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.exception.SessaoEncerradaException;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.Associado;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.SessaoDeVoto;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.Voto;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.enums.Decisao;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.repository.VotoRepository;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.stubs.AssociadoStub;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.stubs.SessaoStub;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.stubs.VotoStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertThrows;

@ExtendWith(MockitoExtension.class)
class VotoServiceTest {

    @InjectMocks
    VotoService votoService;
    Voto voto = VotoStub.gerarVotoNegativo();
    SessaoDeVoto sessao = SessaoStub.gerarSessao();
    Associado associado = AssociadoStub.gerarAssociado();
    @Mock
    private VotoRepository votoRepository;
    @Mock
    private AssociadoService associadoService;
    @Mock
    private SessaoService sessaoService;
    @Spy
    private VotoMapper mapper;

    @Test
    void deveVotarComSucesso() {
        Mockito.when(associadoService.buscarAssociado("13093250064")).thenReturn(associado);
        Mockito.when(sessaoService.buscarSessaoNoBanco(1)).thenReturn(sessao);
        Mockito.when(votoRepository.save(voto)).thenReturn(voto);
        Mockito.when(votoRepository.existsByAssociadoAndSessao(associado, sessao)).thenReturn(false);

        Assertions.assertEquals(Decisao.NAO, votoService.votar(VotoStub.gerarRequestNegativo()).decisao());
    }

    @Test
    void deveDarErroAoVotarPoisAssociadoInexistente() {
        Mockito.when(associadoService.buscarAssociado("13093250064")).thenThrow(ObjetoNaoEncontradoException.class);

        assertThrows(ObjetoNaoEncontradoException.class, () -> votoService.votar(VotoStub.gerarRequestNegativo()));
    }

    @Test
    void deveDarErroAoVotarPoisAssociadoJaVotou() {
        Mockito.when(associadoService.buscarAssociado("13093250064")).thenReturn(associado);
        Mockito.when(sessaoService.buscarSessaoNoBanco(1)).thenReturn(sessao);
        Mockito.when(votoRepository.existsByAssociadoAndSessao(associado, sessao)).thenReturn(true);

        assertThrows(AssociadoJaVotouException.class, () -> votoService.votar(VotoStub.gerarRequestNegativo()));
    }

    @Test
    void deveDarErroAoVotarPoisSessaoInexistente() {
        Mockito.when(associadoService.buscarAssociado("13093250064")).thenReturn(associado);
        Mockito.when(sessaoService.buscarSessaoNoBanco(1)).thenThrow(ObjetoNaoEncontradoException.class);

        assertThrows(ObjetoNaoEncontradoException.class, () -> votoService.votar(VotoStub.gerarRequestNegativo()).decisao());
    }

    @Test
    void deveDarErroAoVotarPoisSessaoJaExpirou() {
        Mockito.when(associadoService.buscarAssociado("13093250064")).thenReturn(associado);
        Mockito.when(sessaoService.buscarSessaoNoBanco(1)).thenReturn(sessao);
        sessao.definirSessaoComoEncerrada();
        Mockito.when(votoRepository.existsByAssociadoAndSessao(associado, sessao)).thenReturn(false);

        assertThrows(SessaoEncerradaException.class, () -> votoService.votar(VotoStub.gerarRequestNegativo()));
    }
}