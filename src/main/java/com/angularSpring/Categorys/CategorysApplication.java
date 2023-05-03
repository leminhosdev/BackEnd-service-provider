package com.angularSpring.Categorys;

import com.angularSpring.Categorys.domain.Categoria;
import com.angularSpring.Categorys.domain.Livro;
import com.angularSpring.Categorys.repositorys.CategoriaRepository;
import com.angularSpring.Categorys.repositorys.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CategorysApplication implements CommandLineRunner {
@Autowired
private CategoriaRepository categoriaRepository;

@Autowired
private LivroRepository livroRepository;


public static void main(String[] args) {
		SpringApplication.run(CategorysApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria( null, "dudu", "malah");
		Livro livro = new Livro(null, "clena  code", "arquitertrua", "lorem", cat1);
		cat1.getLivros().addAll(Arrays.asList(livro));

		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(livro));

	}
}
