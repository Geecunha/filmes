package org.acme.entitys;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Autor")
public class Autor  extends PanacheEntity {
    public String nome;
    public String cpf;
    public String idade;
    @ManyToMany
    public List<Livro> livrosAutor;
    @ManyToMany
    public List<Editora> editoraAutor;

    public Autor() { // opção de construtor para que o preenchimento dos dados possam ser em branco
    }

    public Autor(int id, String nome, String cpf, String idade, List<Livro> livrosAutor, List<Editora> editoraAutor) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.livrosAutor = livrosAutor;
        this.editoraAutor = editoraAutor;
    }
}
