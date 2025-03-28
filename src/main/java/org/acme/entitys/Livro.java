package org.acme.entitys;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "Livro")
public class Livro  extends PanacheEntity {
    public String titulo;
    public String autor;
    public String editora;
    public int numPag;
    public String genero;

    public Livro() { // opção de construtor para que o preenchimento dos dados possam ser em branco
    }
    public Livro(int id, String titulo, String autor, String editora, int numPag, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.numPag = numPag;
        this.genero = genero;
    }
}
