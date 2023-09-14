package com.br.org.dbserver.danielrodrigues.desafiovotacao.controller.implementation;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.controller.SessaoController;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.SessaoRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.SessaoComResultadoResponse;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.SessaoResponse;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.service.SessaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sessoes")
public class SessaoControllerImpl implements SessaoController {
    @Autowired
    SessaoService service;

    @Override
    @PostMapping
    public ResponseEntity<SessaoResponse> abrirSessaoDeSesao(@RequestBody @Valid SessaoRequest request) {
        return new ResponseEntity<>(service.abrirUmaSessao(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<SessaoComResultadoResponse> buscarResultadoSessao(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarResultadoDaVotacao(id));
    }
}
