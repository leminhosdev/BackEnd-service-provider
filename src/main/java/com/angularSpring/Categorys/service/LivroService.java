package com.angularSpring.Categorys.service;

import com.angularSpring.Categorys.domain.Categoria;
import com.angularSpring.Categorys.domain.Livro;
import com.angularSpring.Categorys.exceptions.ObjectNotFoundException;
import com.angularSpring.Categorys.repositorys.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private CategoriaService categoriaService;

    public Livro findbyId(Long id){
        Optional<Livro> livro = livroRepository.findById(id);
        return livro.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado"));

    }

    public List<Livro> findAll(Long id){
        categoriaService.findbyId(id);
        return livroRepository.findAllByCategoria(id);
    }

    public void delete(Long id){
       findbyId(id);
      try{
          livroRepository.deleteById(id);
      } catch (DataIntegrityViolationException e){
          throw new com.angularSpring.Categorys.exceptions.DataIntegrityViolationException("Livro não pode ser deletado");
      }
    }

    public Livro update(Long id, Livro obj) {
        Livro newObj =findbyId(id);
        updateData(newObj,obj);
        return livroRepository.save(newObj);
    }

    private void updateData(Livro newObj, Livro obj) {
        newObj.setTitulo(obj.getTitulo());
        newObj.setNome_autor(obj.getNome_autor());
        newObj.setTexto(obj.getTexto());

    }

    public Livro create(Long idCat, Livro obj) {
        obj.setId(null);
        Categoria cat = categoriaService.findbyId(idCat);
        obj.setCategoria(cat);
        return livroRepository.save(obj);
    }
}
