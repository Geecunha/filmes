package org.acme.entitys;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "editora")
public class Editora extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long editora_id;

    public String nome;
    @Column(unique = true, nullable = false)
    public String cnpj;
    public String site;
    public String cep;

    // Uma editora pode ter muitos livros
    @OneToMany(mappedBy = "editora")
    public List<Livro> livrosEditora;

    // Muitos autores podem publicar em muitas editoras
    @ManyToMany
    @JoinTable(
            name = "editora_autor", // tabela intermediária
            joinColumns = @JoinColumn(name = "editora_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    public Set<Autor> autoresEditora;

    // Construtor padrão
    public Editora() {}

    public Editora(String nome, String cnpj, String site, String cep, List<Livro> livrosEditora, Set<Autor> autoresEditora) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.site = site;
        this.cep = cep;
        this.livrosEditora = livrosEditora;
        this.autoresEditora = autoresEditora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public List<Livro> getLivrosEditora() {
        return livrosEditora;
    }

    public void setLivrosEditora(List<Livro> livrosEditora) {
        this.livrosEditora = livrosEditora;
    }

    public Set<Autor> getAutoresEditora() {
        return autoresEditora;
    }

    public void setAutoresEditora(Set<Autor> autoresEditora) {
        this.autoresEditora = autoresEditora;
    }

    @Override
    public String toString() {
        return "Editora{" +
                "editora_id=" + editora_id +
                ", nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", site='" + site + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
