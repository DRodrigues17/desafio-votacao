package com.br.org.dbserver.danielrodrigues.desafiovotacao.repository;

import com.br.org.dbserver.danielrodrigues.desafiovotacao.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Integer> {
}
