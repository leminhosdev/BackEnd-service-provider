package com.angularSpring.Categorys.service;

import com.angularSpring.Categorys.domain.Categoria;
import com.angularSpring.Categorys.dtos.CategoriaDTO;
import com.angularSpring.Categorys.exceptions.ObjectNotFoundException;
import com.angularSpring.Categorys.repositorys.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    public Categoria findbyId(Long id){
        Optional<Categoria> categoria = this.categoriaRepository.findById(id);
       return categoria.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado "));

    }

    public List<Categoria> findall(){
        List<Categoria> all = this.categoriaRepository.findAll();
        return all;
    }
    public Categoria create(Categoria onj){
        onj.setId(null);
        return categoriaRepository.save(onj);
    }

    public  Categoria create(Long id, CategoriaDTO obj){
        Categoria cat = findbyId(id);
        cat.setNome(obj.getNome());
        cat.setDescricao(obj.getDescricao());
        return categoriaRepository.save(cat);


    }

    public void delete(Long id) {
        findbyId(id);
        try {
            categoriaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new com.angularSpring.Categorys.exceptions.DataIntegrityViolationException("Categoria não pdoe ser deletada");
        }

    }
}
