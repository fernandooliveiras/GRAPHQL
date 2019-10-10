package com.solutis.resolver.query;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.solutis.model.Livro;
import com.solutis.repository.LivroRepository;

@Component
public class QueryLivro implements GraphQLQueryResolver{

	private LivroRepository livroRepository;
	
	@Autowired
	public QueryLivro(LivroRepository livroRepository) {
		super();
		this.livroRepository = livroRepository;
	
	}

	public Iterable<Livro> findAllLivros(){
		return livroRepository.findAll();
	}

	public long countLivros() {
		return livroRepository.count();
	}

	public Iterable<Livro> findLivroByName(String titulo) {

		List<Livro> livros = new ArrayList<Livro>();
		livros = livroRepository.findAll();

		List<Livro> livrosAchados = new ArrayList<Livro>();

		livros.forEach(livro -> {
			if(livro.getTitulo().contains(titulo))
				livrosAchados.add(livro);
		});

		return livrosAchados;
	}

	public Iterable<Livro> findLivroByAutor(String autor){
		List<Livro> livros = new ArrayList<Livro>();
		livros = livroRepository.findAll();

		List<Livro> livrosAchados = new ArrayList<Livro>();

		livros.forEach(livro -> {
			if(livro.getAutor().getNome().equalsIgnoreCase(autor))
				livrosAchados.add(livro);
		});

		return livrosAchados;
	}


}
