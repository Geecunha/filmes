package org.acme.entitys;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "livro")
public class Livro extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long livro_id;
    public String titulo;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    public Autor autor;

    @ManyToOne
    @JoinColumn(name = "editora_id", nullable = false)
    public Editora editora;

    @Column(name = "num_paginas")
    public int numPag;

    public Livro() {}

    public Livro(String titulo, Autor autor, Editora editora, int numPag) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.numPag = numPag;
    }

    public Long getLivro_id() {
        return livro_id;
    }

    public void setLivro_id(Long livro_id) {
        this.livro_id = livro_id;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "livro_id=" + livro_id +
                ", titulo='" + titulo + '\'' +
                ", autor=" + autor +
                ", editora=" + editora +
                ", numPag=" + numPag +
                '}';
    }
}
