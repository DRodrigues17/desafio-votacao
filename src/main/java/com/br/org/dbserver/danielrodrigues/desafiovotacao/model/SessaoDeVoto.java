package com.br.org.dbserver.danielrodrigues.desafiovotacao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalTime;
import java.util.List;

@Entity
public class SessaoDeVoto {
    @Id
    private Integer id;
    private final LocalTime horaDeAbertura;
    private final LocalTime horaDeFechamento;
    private Integer idDaPauta;
    @OneToMany
    private List<Voto> votos;
    private boolean encerrada;

    public SessaoDeVoto(LocalTime horaDeAbertura, LocalTime horaDeFechamento, List<Voto> votos) {
        this.horaDeAbertura = horaDeAbertura;
        this.horaDeFechamento = horaDeFechamento;
        this.votos = votos;
    }

    public SessaoDeVoto(LocalTime horaDeAbertura, List<Voto> votos) {
        this.horaDeAbertura = horaDeAbertura;
        this.horaDeFechamento = horaDeAbertura.plusMinutes(1);
        this.votos = votos;
    }

    public void definirSessaoComoEncerrada() {
        this.encerrada = LocalTime.now().isAfter(horaDeFechamento);
    }
}
