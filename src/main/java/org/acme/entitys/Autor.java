package org.acme.entitys;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;

@Entity
@Table(name = "autor")
public class Autor extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long autor_id;


    public String nome;

    @Column(unique = true, nullable = false)
    public String cpf;
    public int idade;

    // Um autor pode escrever vários livros
    @OneToMany(mappedBy = "autor")
    public List<Livro> livrosAutor;

    // Muitos autores podem publicar em muitas editoras
    @ManyToMany(mappedBy = "autoresEditora")
    public List<Editora> editoraAutor;

    public Autor() {}

    public Autor(String nome, String cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<Livro> getLivrosAutor() {
        return livrosAutor;
    }

    public void setLivrosAutor(List<Livro> livrosAutor) {
        this.livrosAutor = livrosAutor;
    }

    public List<Editora> getEditoraAutor() {
        return editoraAutor;
    }

    public void setEditoraAutor(List<Editora> editoraAutor) {
        this.editoraAutor = editoraAutor;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "autor_id=" + autor_id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", idade=" + idade +
                ", livrosAutor=" + livrosAutor +
                ", editoraAutor=" + editoraAutor +
                '}';
    }
}
