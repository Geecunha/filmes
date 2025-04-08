package org.acme.entitys;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.acme.enums.Genero;
import jakarta.validation.constraints.*;

import java.util.List;
import java.util.Set;

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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public Genero genero;

    // Um autor pode escrever vários livros
    @OneToMany(mappedBy = "autor")
    public List<Livro> livrosAutor;

    // Muitos autores podem publicar em muitas editoras
    @ManyToMany(mappedBy = "autoresEditora")
    public Set<Editora> editoraAutor;

    public Autor() {}

    public Autor(String nome, String cpf, int idade, Genero genero) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.genero = genero;
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

    public Set<Editora> getEditoraAutor() {
        return editoraAutor;
    }

    public void setEditoraAutor(Set<Editora> editoraAutor) {
        this.editoraAutor = editoraAutor;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "autor_id=" + autor_id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", idade=" + idade +
                ", genero=" + genero +
                ", livrosAutor=" + livrosAutor +
                ", editoraAutor=" + editoraAutor +
                '}';
    }
}
