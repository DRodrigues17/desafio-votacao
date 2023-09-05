package com.br.org.dbserver.danielrodrigues.desafiovotacao.repository;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, Integer> {
}
