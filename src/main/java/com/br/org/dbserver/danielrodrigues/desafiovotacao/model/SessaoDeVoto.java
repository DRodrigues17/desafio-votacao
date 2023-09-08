package com.br.org.dbserver.danielrodrigues.desafiovotacao.model;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.enums.Decisao;
import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.enums.SituacaoPauta;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
public class SessaoDeVoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private final LocalDateTime horaDeAbertura;
    private final LocalDateTime horaDeFechamento;
    private final Integer idDaPauta;
    @Setter
    @OneToMany(mappedBy = "sessao")
    private List<Voto> votos;
    private boolean encerrada;

    @Builder
    public SessaoDeVoto(LocalDateTime horaDeAbertura, LocalDateTime horaDeFechamento, Integer idDaPauta) {
        this.horaDeAbertura = horaDeAbertura;
        this.horaDeFechamento = horaDeFechamento;
        this.idDaPauta = idDaPauta;
    }

    public void definirSessaoComoEncerrada() {
        encerrada = true;
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
        return votosPositivos < votosNegativos ? SituacaoPauta.RECUSADA : SituacaoPauta.APROVADA;
    }
}
