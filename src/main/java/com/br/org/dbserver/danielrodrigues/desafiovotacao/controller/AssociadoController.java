package com.br.org.dbserver.danielrodrigues.desafiovotacao.controller;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.AssociadoRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.AssociadoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

public interface AssociadoController {
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Retorna associado adastrado"),
            @ApiResponse(responseCode = "422", description = "Lança uma lista de erros caso o cpf seja inválido, o nome esteja em branco ou não seja do tamanho permitido")
    })
    @Operation(description = "Cadastra um associado")

    ResponseEntity<AssociadoResponse> cadastrarAssociado(AssociadoRequest request);
}
