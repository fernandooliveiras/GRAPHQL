package com.solutis.resolver.query;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.solutis.model.Biblioteca;
import com.solutis.repository.BibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class QueryBiblioteca implements GraphQLQueryResolver {

    private BibliotecaRepository bibliotecaRepository;

    @Autowired
    public QueryBiblioteca(BibliotecaRepository bibliotecaRepository) {
        super();
        this.bibliotecaRepository = bibliotecaRepository;
    }

    public Iterable<Biblioteca> findAllBibliotecas(){
        System.out.println(bibliotecaRepository.findAll());
        return bibliotecaRepository.findAll();
    }

    public Long countBibliotecas(){
        return bibliotecaRepository.count();
    }

    public Iterable<Biblioteca> findBibliotecaByName(String nome) {

        ArrayList<Biblioteca> bibliotecas = new ArrayList<Biblioteca>();
        bibliotecas = (ArrayList<Biblioteca>) bibliotecaRepository.findAll();

        ArrayList<Biblioteca> bibliotecasAchadas = new ArrayList<Biblioteca>();


        bibliotecas.forEach(biblioteca -> {
            if(biblioteca.getNome().contains(nome))
                bibliotecasAchadas.add(biblioteca);
        });

        return bibliotecasAchadas;
    }

    public Iterable<Biblioteca> findBibliotecaByEndereco(String endereco) {

        ArrayList<Biblioteca> bibliotecas = new ArrayList<Biblioteca>();
        bibliotecas = (ArrayList<Biblioteca>) bibliotecaRepository.findAll();

        ArrayList<Biblioteca> bibliotecasAchadas = new ArrayList<Biblioteca>();


        bibliotecas.forEach(biblioteca -> {
            if(biblioteca.getEndereco().contains(endereco))
                bibliotecasAchadas.add(biblioteca);
        });

        return bibliotecasAchadas;
    }


}
