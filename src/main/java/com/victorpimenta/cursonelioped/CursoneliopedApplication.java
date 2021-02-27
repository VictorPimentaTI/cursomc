package com.victorpimenta.cursonelioped;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.victorpimenta.cursonelioped.domain.Categoria;
import com.victorpimenta.cursonelioped.domain.Cidade;
import com.victorpimenta.cursonelioped.domain.Estado;
import com.victorpimenta.cursonelioped.domain.Produto;
import com.victorpimenta.cursonelioped.repositories.CategoriaRepository;
import com.victorpimenta.cursonelioped.repositories.CidadeRepository;
import com.victorpimenta.cursonelioped.repositories.EstadoRepository;
import com.victorpimenta.cursonelioped.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoNelioPedApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoNelioPedApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto pro1 = new Produto(null, "Computador", 2000.00);
		Produto pro2 = new Produto(null, "Impressora", 800.00);
		Produto pro3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(pro1, pro2, pro3));
		cat2.getProdutos().addAll(Arrays.asList(pro2));

		pro1.getCategorias().addAll(Arrays.asList(cat1));
		pro2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		pro3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(pro1, pro2, pro3));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		
	}

}
