package com.br.org.dbserver.danielrodrigues.desafiovotacao.controller.implementation;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.controller.VotoController;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.request.VotoRequest;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.dto.response.VotoResponse;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.service.VotoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/votos")
@RequiredArgsConstructor
public class VotoControllerImpl implements VotoController {
    VotoService service;

    @PostMapping
    @Override
    public ResponseEntity<VotoResponse> votar(@RequestBody @Valid VotoRequest request) {
        return new ResponseEntity<>(service.votar(request), HttpStatus.CREATED);
    }
}
