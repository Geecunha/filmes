package org.acme.entitys;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Editora")
public class Editora extends PanacheEntity {
    public String nome;
    public String cnpj;
    public String site;
    public int cep;
    @ManyToMany
    public List<Livro> livrosEditora;
    @ManyToMany
    public List<Autor> autoresEditora;

    public Editora() { // opção de construtor para que o preenchimento dos dados possam ser em branco
    }

    public Editora(int id, String nome, String cnpj, String site, int cep, List<Livro> livrosEditora, List<Autor> autoresEditora) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.site = site;
        this.cep = cep;
        this.livrosEditora = livrosEditora;
        this.autoresEditora = autoresEditora;
    }
}






