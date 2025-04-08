package org.acme.DTO;

public class LivroResumoDTO {
    public Long id;
    public String titulo;

    public LivroResumoDTO(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }
}