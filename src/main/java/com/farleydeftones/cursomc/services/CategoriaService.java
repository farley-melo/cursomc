package com.farleydeftones.cursomc.services;

import com.farleydeftones.cursomc.domain.Categoria;
import com.farleydeftones.cursomc.repositories.CategoriaRepository;
import com.farleydeftones.cursomc.services.exceptions.ObjectNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscar(Integer id){
        Optional<Categoria> obj=this.categoriaRepository.findById(id);
        return obj.orElseThrow(()->new ObjectNaoEncontradoException("A categoria nao foi encontrada na base de dados"));
    }
}
