package com.br.org.dbserver.danielrodrigues.desafiovotacao.model;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.enums.Decisao;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.enums.SituacaoPauta;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class SessaoDeVoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime horaDeAbertura;
    private LocalDateTime horaDeFechamento;
    private Integer idDaPauta;

    @ElementCollection
    @JsonManagedReference
    @Setter
    @OneToMany(mappedBy = "sessao", fetch = FetchType.EAGER)
    private List<Voto> votos = new ArrayList<>();

    @Builder
    public SessaoDeVoto(LocalDateTime horaDeAbertura, LocalDateTime horaDeFechamento, Integer idDaPauta) {
        this.horaDeAbertura = horaDeAbertura;
        this.horaDeFechamento = horaDeFechamento;
        this.idDaPauta = idDaPauta;
    }

    public SituacaoPauta descobrirResultadoDaVotacao() {
        int votosNegativos = 0;
        int votosPositivos = 0;

        for (Voto voto : votos) {
            if (voto.getDecisao().equals(Decisao.SIM)) {
                votosPositivos += 1;
            } else {
                votosNegativos += 1;
            }
        }
        return votosPositivos <= votosNegativos ? SituacaoPauta.RECUSADA : SituacaoPauta.APROVADA;
    }
}
