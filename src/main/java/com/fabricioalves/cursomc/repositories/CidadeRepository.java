package com.fabricioalves.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabricioalves.cursomc.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
