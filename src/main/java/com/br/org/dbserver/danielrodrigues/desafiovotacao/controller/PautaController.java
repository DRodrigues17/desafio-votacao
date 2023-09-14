package com.br.org.dbserver.danielrodrigues.desafiovotacao.controller;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.PautaRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.PautaResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

public interface PautaController {

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Retorna a pauta cadastrada"),
            @ApiResponse(responseCode = "422", description = "Lança uma lista de erros caso os campos de nome e descrição estejam nulos ou não estejam entre o numero de caracteres permitido")
    })
    @Operation(description = "Cadastra uma pauta para votar")
    ResponseEntity<PautaResponse> cadastrarPauta(PautaRequest request);

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna a pauta informado"),
            @ApiResponse(responseCode = "404", description = "Lança um erro caso a pauta não seja encontrada")
    })
    @Operation(description = "Busca uma pauta pelo id")
    ResponseEntity<PautaResponse> buscarPauta(Integer id);
}
