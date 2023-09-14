package com.br.org.dbserver.danielrodrigues.desafiovotacao.controller;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.SessaoRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.SessaoComResultadoResponse;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.SessaoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

public interface SessaoController {
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Retorna apenas a sessão criada"),
            @ApiResponse(responseCode = "422", description = "Lança uma lista de erros caso o id da pauta esteja nulo"),
            @ApiResponse(responseCode = "404", description = "Lança um erro caso oa pauta seja encontrada")
    })
    @Operation(description = "Abre uma sessão para voto")
    ResponseEntity<SessaoResponse> abrirSessaoDeSesao(SessaoRequest request);

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna a sessão informada"),
            @ApiResponse(responseCode = "404", description = "Lança um erro caso a sessãoo seja encontrada")
    })
    @Operation(description = "Busca uma sessão, retornando os votos, a pauta da sessão e se a sessão já foi encerrada")

    ResponseEntity<SessaoComResultadoResponse> buscarResultadoSessao(Integer id);
}
