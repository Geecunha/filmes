package org.acme.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.acme.entitys.Produtora;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoraDTO {
    public Long id;
    @NotBlank(message = "O nome da editora é obrigatório")
    public String nome;

    @NotBlank(message = "O CNPJ é obrigatório")
    @Size(min = 14, max = 14, message = "O CNPJ deve conter exatamente 14 dígitos")
    public String cnpj;

    @NotBlank(message = "Insira o site da editora")
    public String site;

    @NotBlank(message = "Insira o CEP")
    public String cep;

    public List<FilmeResumoDTO> livros;

    public ProdutoraDTO(Produtora editora) {
        this.id = editora.editora_id;
        this.nome = editora.nome;
        this.cnpj = editora.cnpj;
        this.site = editora.site;
        this.cep = editora.cep;

        this.livros = editora.livrosEditora != null
                ? editora.livrosEditora.stream()
                .map(l -> new FilmeResumoDTO(l.livro_id, l.titulo))
                .collect(Collectors.toList())
                : List.of();
    }
}
