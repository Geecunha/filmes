package org.acme.DTO;

import jakarta.validation.constraints.*;

public class LivroCadastroDTO {

    @NotBlank(message = "O título é obrigatório")
    public String titulo;

    @Min(value = 1, message = "O número de páginas deve ser maior que zero")
    public int numPag;

    @NotNull(message = "O ID do autor é obrigatório")
    public Long autor;

    @NotNull(message = "O ID da editora é obrigatório")
    public Long editora;

}