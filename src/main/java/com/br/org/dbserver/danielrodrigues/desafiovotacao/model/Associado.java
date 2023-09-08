package com.br.org.dbserver.danielrodrigues.desafiovotacao.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class Associado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 11)
    private final Long cpf;
    @Column(length = 50)
    private final String nome;

    @Builder
    public Associado(Long cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }
}
