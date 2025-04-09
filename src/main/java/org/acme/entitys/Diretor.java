package org.acme.entitys;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "diretor")
public class Diretor extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long diretor_id;

    public String nome;
    public String nacionalidade;
    public int idade;

    // Um diretor pode dirigir vários filmes
    @OneToMany(mappedBy = "diretor")
    public List<Filme> filmes;

    public Diretor() {}

    public Diretor(String nome, String nacionalidade, int idade) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.idade = idade;
    }

    public Long getDiretor_id() {
        return diretor_id;
    }

    public void setDiretor_id(Long diretor_id) {
        this.diretor_id = diretor_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    @Override
    public String toString() {
        return "Diretor{" +
                "diretor_id=" + diretor_id +
                ", nome='" + nome + '\'' +
                ", nacionalidade='" + nacionalidade + '\'' +
                ", idade=" + idade +
                '}';
    }
}
