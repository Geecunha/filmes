package org.acme.DTO;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.acme.entitys.Livro;

public class LivroDTO {
    public Long id;
    @NotBlank(message = "O título do livro é obrigatório")
    public String titulo;

    @NotNull(message = "O número de páginas é obrigatório")
    @DecimalMin(value = "1", message = "O número de páginas deve ser maior que zero")
    public int numPag;

    public AutorResumoDTO autor;
    public EditoraResumoDTO  editora;

    public LivroDTO() {}

    public LivroDTO(Livro livro) {
        this.id = livro.livro_id;
        this.titulo = livro.titulo;
        this.numPag = livro.numPag;
        if (livro.autor != null) {
            this.autor = new AutorResumoDTO(livro.autor.autor_id, livro.autor.nome);
        }
        if (livro.editora != null) {
            this.editora = new EditoraResumoDTO(livro.editora.editora_id, livro.editora.nome);
        }
    }
}

