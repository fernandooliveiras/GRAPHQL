package com.solutis.resolver.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.solutis.exceptions.LivroException;
import com.solutis.model.Biblioteca;
import com.solutis.model.Livro;
import com.solutis.repository.BibliotecaRepository;
import com.solutis.repository.LivroRepository;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class MutationBiblioteca implements GraphQLMutationResolver {
    private BibliotecaRepository bibliotecaRepository;

    LivroRepository livroRepository;
    @Autowired
    public MutationBiblioteca (BibliotecaRepository bibliotecaRepository,
                               LivroRepository livroRepository){
        super();
        this.bibliotecaRepository = bibliotecaRepository;
        this.livroRepository = livroRepository;
    }

    public Biblioteca novaBiblioteca(String nome, String endereco){
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setNome(nome);
        biblioteca.setEndereco(endereco);
        bibliotecaRepository.save(biblioteca);

        return biblioteca;
    }

    public Biblioteca adicionaLivro(Long idBiblioteca, Long idLivro){

        Biblioteca biblioteca = new Biblioteca();
        biblioteca = bibliotecaRepository.findById(idBiblioteca).get();

        Livro livro = livroRepository.findById(idLivro).get();
        List<Livro> livros;
        livros = livroRepository.findAll();
        livros.add(livro);
//        biblioteca.setLivros(livros);
        biblioteca.addLivros(livro);

        return biblioteca;
    }

    public boolean deleteBiblioteca(Long id) {

        bibliotecaRepository.deleteById(id);;
        return true;
    }

    public Biblioteca updateEndereco(String endereco, Long id){
        Biblioteca biblioteca = bibliotecaRepository.findById(id).get();

        if(biblioteca == null)
            throw new LivroException("ID de biblioteca inválido", id);

        biblioteca.setEndereco(endereco);

        bibliotecaRepository.save(biblioteca);
        return biblioteca;
    }

    public Biblioteca updateNome(String nome, Long id){
        Biblioteca biblioteca = bibliotecaRepository.findById(id).get();

        if(biblioteca == null)
            throw new LivroException("ID de biblioteca inválido", id);

        biblioteca.setEndereco(nome);

        bibliotecaRepository.save(biblioteca);
        return biblioteca;
    }


}
