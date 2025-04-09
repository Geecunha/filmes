package org.acme.DTO;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.acme.entitys.Diretor;
import org.acme.enums.Genero;

import java.util.List;
import java.util.stream.Collectors;

public class DiretorDTO {
    public Long id;
    @NotBlank(message = "O nome do autor é obrigatório")
    public String nome;

    @NotBlank(message = "A nacionalidade é obrigatório")

    public String nacionalidade;

    @DecimalMin(value = "18", message = "O diretor deve ter mais que 18 anos")
    public int idade;



    public List<FilmeResumoDTO> filme;

    public DiretorDTO(Diretor diretor) {
        this.id = diretor.diretor_id;
        this.nome = diretor.nome;
        this.nacionalidade = diretor.nacionalidade;
        this.idade = diretor.idade;


        this.filme = diretor.filmeDiretor != null
                ? diretor.filmeDiretor.stream()
                .map(l -> new FilmeResumoDTO(l.filme_id, f.titulo))
                .collect(Collectors.toList())
                : List.of();
    }
}