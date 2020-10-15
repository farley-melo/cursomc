package com.farleydeftones.cursomc.repositories;

import com.farleydeftones.cursomc.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {
}
