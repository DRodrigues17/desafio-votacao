package com.br.org.dbserver.danielrodrigues.desafiovotacao.model;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.enums.Decisao;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@Entity
public class Voto {
    @Id
    @Getter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_associado")
    private Associado associado;
    @ManyToOne
    @JoinColumn(name = "id_sessao")
    private SessaoDeVoto sessao;
    private Decisao decisao;
}
