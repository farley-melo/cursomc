package com.farleydeftones.cursomc.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    private String nome;
    private Double preco;
    @ManyToMany
    @JoinTable
            (
                    name = "PRODUTO_CATEGORIA",
                    joinColumns = @JoinColumn(name = "produto_id"),
                    inverseJoinColumns = @JoinColumn(name = "categoria_id")
            )
    private List<Categoria> categorias=new ArrayList<>();

    public Produto(){

    }
    public Produto(Integer id,String nome,Double preco){
        this.id=id;
        this.nome=nome;
        this.preco=preco;
    }

}
