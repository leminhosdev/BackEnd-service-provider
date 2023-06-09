package com.angularSpring.Categorys.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Livro implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
   @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;


}
