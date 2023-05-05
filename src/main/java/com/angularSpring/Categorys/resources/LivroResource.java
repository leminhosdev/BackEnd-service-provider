package com.angularSpring.Categorys.resources;

import com.angularSpring.Categorys.domain.Livro;
import com.angularSpring.Categorys.dtos.LivroDTO;
import com.angularSpring.Categorys.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin("-")
@RestController
@RequestMapping(value = "/livros")
public class LivroResource {
    @Autowired
    private LivroService livroService;
    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Long id){
        Livro livro = livroService.findbyId(id);
        return ResponseEntity.ok().body(livro);
    }
    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria",defaultValue = "0") Long id_cat){
        List<Livro> livros = livroService.findAll(id_cat);
        List<LivroDTO> livroDTOS = livros.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(livroDTOS);

    }

    @PutMapping( value = "/{id}")
    public ResponseEntity<Livro> update(@PathVariable Long id, @Valid @RequestBody Livro obj){
        Livro newObj = livroService.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }


    @PostMapping
    public ResponseEntity<Livro> create( @RequestParam(value = "categoria", defaultValue = "0")Long id_cat,@Valid @RequestBody Livro obj){
        Livro newObj = livroService.create(id_cat, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
