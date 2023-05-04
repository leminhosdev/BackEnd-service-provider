package com.angularSpring.Categorys.service;

import com.angularSpring.Categorys.domain.Categoria;
import com.angularSpring.Categorys.exceptions.ObjectNotFoundException;
import com.angularSpring.Categorys.repositorys.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    public Categoria findbyId(Long id){
        Optional<Categoria> categoria = this.categoriaRepository.findById(id);
       return categoria.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado "));

    }

}
