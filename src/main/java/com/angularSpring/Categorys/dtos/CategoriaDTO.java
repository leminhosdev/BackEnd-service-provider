package com.angularSpring.Categorys.dtos;

import com.angularSpring.Categorys.domain.Categoria;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter

@NoArgsConstructor
public class CategoriaDTO implements Serializable {
    private static final Long serialVersionUID = 1L;
    private Long id;
    @NotEmpty(message = "esse nome não pode estar vazio")
    @Length(min = 5, max = 100, message = "O campo deve ter entre 5 e 100 caracteres")
    private String nome;
    @NotEmpty(message = "descrição vazia")
    @Length(min = 5, max = 200, message = "O campo deve ter entre 5 e 200 caracteres")
    private String descricao;

    public CategoriaDTO(Categoria obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.descricao = obj.getDescricao();
    }
}
