package com.angularSpring.Categorys.dtos;

import com.angularSpring.Categorys.domain.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter

@NoArgsConstructor
public class CategoriaDTO implements Serializable {
    private static final Long serialVersionUID = 1L;
    private Long id;
    private String nome;

    private String descrição;

    public CategoriaDTO(Categoria obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.descrição = obj.getDescrição();
    }
}
