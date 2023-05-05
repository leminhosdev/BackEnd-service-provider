package com.angularSpring.Categorys.domain;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Categoria implements Serializable {

    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "esse nome não pode estar vazio")
    @Length(min = 5, max = 100, message = "O campo deve ter entre 5 e 100 caracteres")
    private String nome;
    @NotEmpty(message = "descrição vazia")
    @Length(min = 5, max = 200, message = "O campo deve ter entre 5 e 200 caracteres")
    private String descrição;
    @OneToMany(mappedBy = "categoria")
    private List<Livro> livros = new ArrayList<>();


    public Categoria(Long id, String nome, String descrição) {
        this.id = id;
        this.nome = nome;
        this.descrição = descrição;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return id == categoria.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
