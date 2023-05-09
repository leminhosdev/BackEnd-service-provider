package com.angularSpring.Categorys.resources;

import com.angularSpring.Categorys.domain.Categoria;
import com.angularSpring.Categorys.dtos.CategoriaDTO;
import com.angularSpring.Categorys.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin("http://localhost:4200")
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
    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findall(){
        List<Categoria> all = categoriaService.findall();
        List<CategoriaDTO> listDTO = all.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
    @PostMapping
    public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria obj){
    categoriaService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoriaDTO>update(@javax.validation.Valid @PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO){
        Categoria newObj = categoriaService.create(id, categoriaDTO);
        return ResponseEntity.ok().body(new CategoriaDTO(newObj));
    }
    @DeleteMapping(value ="/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }


}


