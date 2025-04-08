package org.acme.DTO;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.acme.entitys.Autor;

import java.util.List;
import java.util.stream.Collectors;

public class AutorDTO {
    public Long id;
    @NotBlank(message = "O nome do autor é obrigatório")
    public String nome;

    @NotBlank(message = "O CPF é obrigatório")
    @Size(min = 11, max = 11, message = "O CPF deve conter exatamente 11 dígitos")
    public String cpf;

    @DecimalMin(value = "18", message = "O autor deve ter mais que 18 anos")
    public int idade;

    public List<LivroResumoDTO> livros;

    public AutorDTO(Autor autor) {
        this.id = autor.autor_id;
        this.nome = autor.nome;
        this.cpf = autor.cpf;
        this.idade = autor.idade;
        this.livros = autor.livrosAutor != null
                ? autor.livrosAutor.stream()
                .map(l -> new LivroResumoDTO(l.livro_id, l.titulo))
                .collect(Collectors.toList())
                : List.of();
    }
}