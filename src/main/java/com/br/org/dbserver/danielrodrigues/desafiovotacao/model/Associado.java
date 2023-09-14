package com.br.org.dbserver.danielrodrigues.desafiovotacao.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Associado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 14)
    private String cpf;
    @Column(length = 50)
    private String nome;

    @Builder
    public Associado(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }
}
