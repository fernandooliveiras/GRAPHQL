package com.solutis.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Biblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String endereco;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "bibliotecas_livros")
    List<Livro> livros;

    public Biblioteca(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;

    }

    public Biblioteca(String nome, String endereco, List<Livro> livros) {
        this.nome = nome;
        this.endereco = endereco;
        this.livros = livros;
    }

    public Biblioteca(Long id) {
        this.id = id;
    }

    public Biblioteca() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public void addLivros(Livro livro){
        this.livros.add(livro);
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", livros=" + livros +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Biblioteca that = (Biblioteca) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(endereco, that.endereco) &&
                Objects.equals(livros, that.livros);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, endereco, livros);
    }

}
