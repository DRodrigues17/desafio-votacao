package com.br.org.dbserver.danielrodrigues.desafiovotacao.model;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.enums.SituacaoPauta;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public class Pauta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    @Enumerated(EnumType.STRING)
    @Setter
    private SituacaoPauta situacao;

    @Builder
    public Pauta(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.situacao = SituacaoPauta.PARA_VOTAR;
    }
}
