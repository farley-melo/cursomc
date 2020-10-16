package com.farleydeftones.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @ManyToMany(mappedBy = "categorias")
    @JsonManagedReference
    private List<Produto> produtos=new ArrayList<>();

    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public Categoria(){
    }
}
