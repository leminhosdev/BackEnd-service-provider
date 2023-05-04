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
public class CategorysApplication  {


public static void main(String[] args) {
		SpringApplication.run(CategorysApplication.class, args);
	}


}
