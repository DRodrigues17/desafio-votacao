package com.br.org.dbserver.danielrodrigues.desafiovotacao.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@EqualsAndHashCode
@Entity
@NoArgsConstructor
public class Associado {
    @Getter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 14, unique = true)
    private String cpf;
    @Column(length = 50)
    private String nome;

    @Builder
    public Associado(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }
}
