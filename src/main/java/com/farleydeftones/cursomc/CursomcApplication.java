package com.farleydeftones.cursomc;

import com.farleydeftones.cursomc.domain.Categoria;
import com.farleydeftones.cursomc.domain.Cidade;
import com.farleydeftones.cursomc.domain.Estado;
import com.farleydeftones.cursomc.domain.Produto;
import com.farleydeftones.cursomc.repositories.CategoriaRepository;
import com.farleydeftones.cursomc.repositories.CidadeReposistory;
import com.farleydeftones.cursomc.repositories.EstadoRepository;
import com.farleydeftones.cursomc.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    ProdutoRepository produtoRepository;
    @Autowired
    CidadeReposistory cidadeReposistory;
    @Autowired
    EstadoRepository estadoRepository;

    public static void main(String[] args) {
        SpringApplication.run(CursomcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria informatica=new Categoria(null,"Informatica");
        Categoria escritorio=new Categoria(null,"Escritorio");
        Produto impressora=new Produto(null,"Impressora",800.0);
        Produto mouse=new Produto(null,"Mouse",50.0);
        Produto computador=new Produto(null,"Computador",2000.0);
        //associar categoria ao produto
        informatica.getProdutos().addAll(Arrays.asList(impressora,mouse,computador));
        //associar produto a categoria
        impressora.getCategorias().addAll(Arrays.asList(informatica,escritorio));
        mouse.getCategorias().addAll(Arrays.asList(informatica));
        computador.getCategorias().addAll(Arrays.asList(informatica));

        Estado saoPaulo=new Estado(null,"Sao Paulo");
        Estado minasGeraes=new Estado(null,"Minas Geraes");
        Cidade saoCaetano=new Cidade(null,"Sae Caetano",saoPaulo);
        Cidade uberlandia=new Cidade(null,"Uberlandia",minasGeraes);
        Cidade campinas=new Cidade(null,"Campinas",saoPaulo);
        saoPaulo.getCidades().addAll(Arrays.asList(saoCaetano,campinas));
        minasGeraes.getCidades().addAll(Arrays.asList(uberlandia));

        this.categoriaRepository.saveAll(Arrays.asList(informatica,escritorio));
        this.produtoRepository.saveAll(Arrays.asList(impressora,mouse,computador));
    }
}
