package com.farleydeftones.cursomc.domain;

import com.farleydeftones.cursomc.domain.enums.TipoCliente;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.awt.image.TileObserver;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String cpf;
    private Integer tipo;
    @OneToMany(mappedBy = "cliente")
    private List<Endereco>enderecos=new ArrayList<>();
    @ElementCollection
    @CollectionTable(name = "telofone")
    private Set<String>telefones=new HashSet<>();

    public TipoCliente getTipo(){
        return TipoCliente.toEnum(tipo);
    }
    public void setTipo(TipoCliente tipoCliente){
        this.tipo=tipoCliente.getCod();
    }

    public Cliente(Integer id, String nome, String email, String cpf, TipoCliente tipoCliente) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.tipo = tipoCliente.getCod();
    }
}
