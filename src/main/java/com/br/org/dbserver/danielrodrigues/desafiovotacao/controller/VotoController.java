package com.br.org.dbserver.danielrodrigues.desafiovotacao.controller;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.VotoRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.VotoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

public interface VotoController {
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Retorna apenas o voto informado"),
            @ApiResponse(responseCode = "405", description = "Lança um erro informando que a sessão já foi encerrada, logo não é permitido votar"),
            @ApiResponse(responseCode = "400", description = "Lança um erro informando que o associado já votou, logo não é permitido votar"),
            @ApiResponse(responseCode = "422", description = "Lança um erro informando que o a decisão passada é inválida"),
            @ApiResponse(responseCode = "422", description = "Lança uma lista de erros caso os campos de associado e sessão estejam nulos"),
            @ApiResponse(responseCode = "404", description = "Lança um erro caso o associado ou sessão não sejam encontrados")
    })
    @Operation(description = "Realiza o voto do associado passado na pauta escolhida")
    ResponseEntity<VotoResponse> votar(VotoRequest request);
}
