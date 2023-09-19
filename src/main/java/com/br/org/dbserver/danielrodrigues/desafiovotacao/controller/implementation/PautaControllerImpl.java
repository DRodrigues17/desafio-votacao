package com.br.org.dbserver.danielrodrigues.desafiovotacao.controller.implementation;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.controller.PautaController;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.PautaRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.PautaResponse;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.service.PautaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pautas")
@RequiredArgsConstructor
public class PautaControllerImpl implements PautaController {
    private final PautaService service;

    @Override
    @PostMapping
    public ResponseEntity<PautaResponse> cadastrarPauta(@RequestBody @Valid PautaRequest request) {
        return new ResponseEntity<>(service.cadastrarPauta(request), HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<PautaResponse> buscarPauta(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPauta(id));
    }
}
