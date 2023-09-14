package com.br.org.dbserver.danielrodrigues.desafiovotacao.service;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.mapper.SessaoMapper;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.exception.ObjetoNaoEncontradoException;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.SessaoDeVoto;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.repository.SessaoRepository;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.stubs.SessaoStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.Assert.assertThrows;

@ExtendWith(MockitoExtension.class)
class SessaoServiceTest {

    SessaoDeVoto sessao = SessaoStub.gerarSessao();
    @Mock
    private SessaoRepository repository;
    @Mock
    private PautaService pautaService;
    @Spy
    private SessaoMapper mapper;
    @InjectMocks
    private SessaoService sessaoService;

    @Test
    void deveBuscarSessaoNoBancoComSucesso() {
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(sessao));
        Assertions.assertEquals(1, sessaoService.buscarSessaoNoBanco(1).getIdDaPauta());
    }

    @Test
    void buscarSessaoNoBanco() {
        Mockito.when(repository.findById(1)).thenThrow(ObjetoNaoEncontradoException.class);
        assertThrows(ObjetoNaoEncontradoException.class, () -> sessaoService.buscarSessaoNoBanco(1));
    }
}