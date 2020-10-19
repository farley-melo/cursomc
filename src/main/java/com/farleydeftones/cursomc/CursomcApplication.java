package com.farleydeftones.cursomc;

import com.farleydeftones.cursomc.domain.*;
import com.farleydeftones.cursomc.domain.Endereco;
import com.farleydeftones.cursomc.domain.enums.TipoCliente;
import com.farleydeftones.cursomc.repositories.*;
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
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    EnderecoRepository enderecoRepository;

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
        this.estadoRepository.saveAll(Arrays.asList(saoPaulo,minasGeraes));
        this.cidadeReposistory.saveAll(Arrays.asList(saoCaetano,uberlandia,campinas));

        Cliente cli01=new Cliente(null,"Maria Silva","maria@gmail.com","123456", TipoCliente.PESSOAFISICA);
        cli01.getTelefones().addAll(Arrays.asList("270000","28000"));

        Endereco e1=new Endereco(null,"rua Flores","300","apartamento 203","jardim","39000",cli01,uberlandia);
        Endereco e2=new Endereco(null,"avenida matos","105","sala 800","centro","4000",cli01,saoCaetano);

        cli01.getEnderecos().addAll(Arrays.asList(e1,e2));

        this.clienteRepository.save(cli01);
        this.enderecoRepository.saveAll(Arrays.asList(e1,e2));
        this.categoriaRepository.saveAll(Arrays.asList(informatica,escritorio));
        this.produtoRepository.saveAll(Arrays.asList(impressora,mouse,computador));
    }
}
