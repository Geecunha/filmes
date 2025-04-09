package org.acme.DTO;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.acme.entitys.Filme;

public class FilmeDTO {
    public Long id;
    @NotBlank(message = "O título do filme é obrigatório")
    public String titulo;

    @NotNull(message = "A Avaliação do filme é obrigatória")
    @Size(min = 1, max = 5, message = "A Avaliação deve ser entre 1 a 5")
    public int notas;


    public DiretorResumoDTO diretor;
    public ProdutoraResumoDTO  produtora;

    public FilmeDTO() {}

    public FilmeDTO(Filme filme) {
        this.id = Filme.filme_id;
        this.titulo = filme.titulo;
        this.notas = filme.notas;
        if (filme.diretor != null) {
            this.diretor = new DiretorResumoDTO(filme.diretor.diretor_id, filme.diretor.nome);
        }
        if (diretor.produtora != null) {
            this.produtora = new ProdutoraResumoDTO(filme.produtora.produtora_id, filme.produtora.nome);
        }
    }
}

