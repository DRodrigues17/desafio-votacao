package com.br.org.dbserver.danielrodrigues.desafiovotacao.repository;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.SessaoDeVoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessaoRepository extends JpaRepository <SessaoDeVoto, Integer> {
}
