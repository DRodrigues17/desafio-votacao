package com.br.org.dbserver.danielrodrigues.desafiovotacao.model;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.enums.Decisao;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@Entity
public class Voto {
    @Id
    private Integer id;
    private Integer idAssociado;
    private Decisao decisao;
}
