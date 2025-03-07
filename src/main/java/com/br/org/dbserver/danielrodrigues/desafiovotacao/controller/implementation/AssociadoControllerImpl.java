package com.br.org.dbserver.danielrodrigues.desafiovotacao.controller.implementation;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.controller.AssociadoController;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.AssociadoRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.AssociadoResponse;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.service.AssociadoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/associados")
@RequiredArgsConstructor
public class AssociadoControllerImpl implements AssociadoController {
    private final AssociadoService service;

    @PostMapping
    @Override
    public ResponseEntity<AssociadoResponse> cadastrarAssociado(@RequestBody @Valid AssociadoRequest request) {
        return new ResponseEntity<>(service.cadastrarAssociado(request), HttpStatus.CREATED);
    }
}
