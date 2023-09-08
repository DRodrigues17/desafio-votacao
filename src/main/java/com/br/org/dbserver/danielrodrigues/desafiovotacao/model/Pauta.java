package com.br.org.dbserver.danielrodrigues.desafiovotacao.model;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.enums.SituacaoPauta;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
public class Pauta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private final String nome;
    @Lob
    private final String descricao;
    @Setter
    private SituacaoPauta situacao;

    @Builder
    public Pauta(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.situacao = SituacaoPauta.PARA_VOTAR;
    }
}
