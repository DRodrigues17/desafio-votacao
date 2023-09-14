package com.br.org.dbserver.danielrodrigues.desafiovotacao.model;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.enums.Decisao;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Voto {
    @Id
    @Getter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_sessao")
    private SessaoDeVoto sessao;

    @ManyToOne
    @JoinColumn(name = "id_associado")
    private Associado associado;

    @Enumerated(EnumType.STRING)
    private Decisao decisao;

    @Builder
    public Voto(Associado associado, SessaoDeVoto sessao, Decisao decisao) {
        this.associado = associado;
        this.sessao = sessao;
        this.decisao = decisao;
    }
}
