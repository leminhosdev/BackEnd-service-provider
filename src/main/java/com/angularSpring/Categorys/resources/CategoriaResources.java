package com.angularSpring.Categorys.resources;

import com.angularSpring.Categorys.domain.Categoria;
import com.angularSpring.Categorys.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaResources {

    @Autowired
    private CategoriaService categoriaService;
    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id){
        Categoria categoria = categoriaService.findbyId(id);
        return ResponseEntity.ok().body(categoria);
    }

}
