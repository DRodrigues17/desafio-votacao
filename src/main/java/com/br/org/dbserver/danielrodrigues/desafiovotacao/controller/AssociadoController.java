package com.br.org.dbserver.danielrodrigues.desafiovotacao.controller;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.AssociadoRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.AssociadoResponse;
import org.springframework.http.ResponseEntity;

public interface AssociadoController {

    ResponseEntity<AssociadoResponse> cadastrarAssociado(AssociadoRequest request);
}
