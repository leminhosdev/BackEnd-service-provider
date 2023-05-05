package com.angularSpring.Categorys.service;

import com.angularSpring.Categorys.domain.Categoria;
import com.angularSpring.Categorys.domain.Livro;
import com.angularSpring.Categorys.repositorys.CategoriaRepository;
import com.angularSpring.Categorys.repositorys.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DbService {
   @Autowired
    private CategoriaRepository categoriaRepository;
   @Autowired
    private LivroRepository livroRepository;

    public void instanciaDB(){

        Categoria cat1 = new Categoria( null, "dudueee", "malaheee");
        Livro livro = new Livro(null, "clenaee  codeee", "arquitertruaee", "loremeee", cat1);
        cat1.getLivros().addAll(Arrays.asList(livro));

        this.categoriaRepository.saveAll(Arrays.asList(cat1));
        this.livroRepository.saveAll(Arrays.asList(livro));

    }
}
