package com.br.org.dbserver.danielrodrigues.desafiovotacao.controller;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.SessaoRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.SessaoComResultadoResponse;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.SessaoResponse;
import org.springframework.http.ResponseEntity;

public interface SessaoController {
    ResponseEntity<SessaoResponse> abrirSessaoDeSesao(SessaoRequest request);

    ResponseEntity<SessaoComResultadoResponse> buscarResultadoSessao(Integer id);
}
