package com.solutis.resolver.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.solutis.model.Autor;
import com.solutis.repository.AutorRepository;

@Component
public class QueryAutor implements GraphQLQueryResolver{
	
	private AutorRepository autorRepository;
	
	@Autowired
	public QueryAutor(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}
	
	public long countAutores() {
		return autorRepository.count();
	}

	public Iterable<Autor> findAllAutores() {
		return autorRepository.findAll();
	}

	public Autor findAutorById(Long id) {
		return autorRepository.findById(id).get();
	}

}
