package org.acme.entitys;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "filme")
public class Filme extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long filme_id;

    public String titulo;
    public String genero;
    public Double notas;

    @ManyToOne
    @JoinColumn(name = "produtora_id", nullable = false)
    public Produtora produtora;

    @ManyToOne
    @JoinColumn(name = "diretor_id", nullable = false)
    public Diretor diretor;

    public Filme() {}

    public Filme(String titulo, String genero, Double notas, Produtora produtora, Diretor diretor) {
        this.titulo = titulo;
        this.genero = genero;
        this.notas = notas;
        this.produtora = produtora;
        this.diretor = diretor;
    }

    public Long getFilme_id() {
        return filme_id;
    }

    public void setFilme_id(Long filme_id) {
        this.filme_id = filme_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Double getNotas() {
        return notas;
    }

    public void setNotas(Double notas) {
        this.notas = notas;
    }

    public Produtora getProdutora() {
        return produtora;
    }

    public void setProdutora(Produtora produtora) {
        this.produtora = produtora;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "filme_id=" + filme_id +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", notas=" + notas +
                ", produtora=" + produtora +
                ", diretor=" + diretor +
                '}';
    }
}
