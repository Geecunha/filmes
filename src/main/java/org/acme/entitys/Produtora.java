package org.acme.entitys;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "produtora")
public class Produtora extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long produtora_id;

    public String nome;
    public String endereco;

    @OneToMany(mappedBy = "produtora")
    public List<Filme> filmes;

    public Produtora() {}

    public Produtora(String nome, String endereco, List<Filme> filmes) {
        this.nome = nome;
        this.endereco = endereco;
        this.filmes = filmes;
    }

    public Long getProdutora_id() {
        return produtora_id;
    }

    public void setProdutora_id(Long produtora_id) {
        this.produtora_id = produtora_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    @Override
    public String toString() {
        return "Produtora{" +
                "produtora_id=" + produtora_id +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
