package com.br.org.dbserver.danielrodrigues.desafiovotacao.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
@Builder
public class Associado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 11)
    private Long cpf;
    @Column(length = 50)
    private String nome;
}
