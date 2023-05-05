package com.angularSpring.Categorys.dtos;

import com.angularSpring.Categorys.domain.Livro;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter

@NoArgsConstructor
public class LivroDTO implements Serializable {
    private static final Long serialVersionUID = 1L;
    private Long id;
    @NotEmpty(message = "Não  pode estar vazio")
    @Length(min = 5, max = 60)
    private String titulo;
    @NotEmpty(message = "Não  pode estar vazio")
    @Length(min = 5, max = 80)
    private String nome_autor;
    @NotEmpty(message = "Não  pode estar vazio")
    @Length(min = 5, max = 900, message = "texto tem minimo de 5 e maximo de 900")
    private String texto;


    public LivroDTO(Livro dto) {
        this.titulo = dto.getTitulo();
        this.id = dto.getId();
        this.nome_autor = dto.getNome_autor();
        this.texto = dto.getTexto();
    }

}
