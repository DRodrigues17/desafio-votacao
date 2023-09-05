package com.br.org.dbserver.danielrodrigues.desafiovotacao.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;

@Entity
@Builder
public class Associado {
    @Id
    private Integer id;
    @Column(length = 11)
    private Long cpf;
    @Column(length = 50)
    private String nome;
}
