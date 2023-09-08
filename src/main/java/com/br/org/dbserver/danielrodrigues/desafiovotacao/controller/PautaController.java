package com.br.org.dbserver.danielrodrigues.desafiovotacao.controller;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.PautaRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.PautaResponse;
import org.springframework.http.ResponseEntity;

public interface PautaController {

    ResponseEntity<PautaResponse> cadastrarPauta(PautaRequest request);

    ResponseEntity<PautaResponse> buscarPauta(Integer id);
}
