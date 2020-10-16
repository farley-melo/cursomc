package com.farleydeftones.cursomc.repositories;

import com.farleydeftones.cursomc.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeReposistory extends JpaRepository<Cidade,Integer> {
}
