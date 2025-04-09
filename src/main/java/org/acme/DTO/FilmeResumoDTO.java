package org.acme.DTO;

public class FilmeResumoDTO {
    public Long id;
    public String titulo;

    public FilmeResumoDTO(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    // Getters e Setters (opcional, se for usar em APIs com frameworks que exigem)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
