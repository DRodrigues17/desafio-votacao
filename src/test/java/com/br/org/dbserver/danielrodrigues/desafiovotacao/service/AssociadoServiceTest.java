package com.br.org.dbserver.danielrodrigues.desafiovotacao.service;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.mapper.AssociadoMapper;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.AssociadoRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.AssociadoResponse;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.exception.ObjetoNaoEncontradoException;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.Associado;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.repository.AssociadoRepository;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.stubs.AssociadoStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AssociadoServiceTest {
    Associado associado = AssociadoStub.gerarAssociado();
    @Mock
    private AssociadoRepository repository;
    @Spy
    private AssociadoMapper mapper;
    @InjectMocks
    private AssociadoService service;

    @Test
    void deveCadastrarAssociadoComSucesso() {

        when(repository.save(associado)).thenReturn(associado);

        AssociadoRequest request = AssociadoStub.gerarRequest();

        AssociadoResponse response = service.cadastrarAssociado(request);

        assertEquals("13093250064", response.cpf());
    }

    @Test
    void deveBuscarAssociadoComSucesso() {
        Mockito.when(repository.findByCpf("13093250064")).thenReturn(Optional.of(associado));

        assertEquals("Daniel Rodrigues", service.buscarAssociado("13093250064").getNome());
    }

    @Test
    void deveLancarExcessaoCasoAssociadoNaoEncontrado() {
        Mockito.when(repository.findByCpf("1")).thenReturn(Optional.empty());

        ObjetoNaoEncontradoException objetoNaoEncontradoException = assertThrows(ObjetoNaoEncontradoException.class,
                () -> service.buscarAssociado("1"));
        assertEquals("Associado/a 1 não encontrado/a", objetoNaoEncontradoException.getMessage());

    }
}