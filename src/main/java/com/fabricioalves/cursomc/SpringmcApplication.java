package com.fabricioalves.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fabricioalves.cursomc.domain.Categoria;
import com.fabricioalves.cursomc.domain.Cidade;
import com.fabricioalves.cursomc.domain.Cliente;
import com.fabricioalves.cursomc.domain.Endereco;
import com.fabricioalves.cursomc.domain.Estado;
import com.fabricioalves.cursomc.domain.Produto;
import com.fabricioalves.cursomc.domain.enums.TipoCliente;
import com.fabricioalves.cursomc.repositories.CategoriaRepository;
import com.fabricioalves.cursomc.repositories.CidadeRepository;
import com.fabricioalves.cursomc.repositories.ClienteRepository;
import com.fabricioalves.cursomc.repositories.EnderecoRepository;
import com.fabricioalves.cursomc.repositories.EstadoRepository;
import com.fabricioalves.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class SpringmcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringmcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria("Informática");
		Categoria cat2 = new Categoria("Escritório");
		
		Produto p1 = new Produto("Computador", 2000.0);
		Produto p2 = new Produto("Impressora", 800.0);
		Produto p3 = new Produto("Mouse", 80.0);
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().add(p2);
		
		p1.getCategorias().add(cat1);
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().add(cat1);
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);	
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().add(c1);
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "3678912337", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("25140585", "25150910"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "08150070", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "255", "Sala 800", "Centro", "07050020", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.save(cli1);
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
	}
}

