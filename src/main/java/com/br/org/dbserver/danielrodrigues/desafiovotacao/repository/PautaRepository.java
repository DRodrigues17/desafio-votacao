package com.br.org.dbserver.danielrodrigues.desafiovotacao.repository;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PautaRepository extends JpaRepository<Pauta, Integer> {
}
