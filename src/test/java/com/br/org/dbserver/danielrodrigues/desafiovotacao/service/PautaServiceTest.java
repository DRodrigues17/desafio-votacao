package com.br.org.dbserver.danielrodrigues.desafiovotacao.service;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.mapper.PautaMapper;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.exception.ObjetoNaoEncontradoException;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.Pauta;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.enums.SituacaoPauta;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.repository.PautaRepository;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.stubs.PautaStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class PautaServiceTest {

    @Mock
    PautaRepository repository;

    @InjectMocks
    PautaService service;

    Pauta pauta = PautaStub.gerarPauta();

    @Test
    void deveCadastrarPautaComSucesso() {
        Mockito.when(repository.save(pauta)).thenReturn(pauta);
        Assertions.assertEquals("uso de uniforme", service.cadastrarPauta(PautaStub.gerarRequest()).nome());
    }

    @Test
    void deveBuscarPautaComSucesso() {
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(pauta));
        Assertions.assertTrue(service.buscarPauta(1).descricao().contains("nessa pauta decidiremos se é necessário ou não o uso de uniforme no home office"));
    }

    @Test
    void deveLancarErroAoBuscarPorPautaInexistente() {
        Mockito.when(repository.findById(1)).thenReturn(Optional.empty());

        ObjetoNaoEncontradoException objetoNaoEncontradoException = assertThrows(ObjetoNaoEncontradoException.class,
                () -> service.buscarPauta(1));
        assertEquals("Pauta 1 não encontrado/a", objetoNaoEncontradoException.getMessage());
    }

    @Test
    void deveAlterarSituacaoDaPautaComSucesso() {
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(pauta));

        pauta.setSituacao(SituacaoPauta.RECUSADA);

        Pauta novaPauta = repository.findById(1).get();

        Assertions.assertNotEquals(SituacaoPauta.PARA_VOTAR, novaPauta.getSituacao());
    }
}