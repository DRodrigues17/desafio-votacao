package com.br.org.dbserver.danielrodrigues.desafiovotacao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Builder
public class Pauta {
    @Id
    private Integer id;
    private String nome;
    @Lob
    private String descricao;
    @Setter
    private boolean aprovada;
}
