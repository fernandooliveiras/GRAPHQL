package com.solutis.resolver.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.solutis.model.Autor;
import com.solutis.repository.AutorRepository;

@Component
public class MutationAutor implements GraphQLMutationResolver {
	
	private AutorRepository autorRepository;
	
	@Autowired
	public MutationAutor(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}
	
	public Autor novoAutor(Autor autor) {
		return autorRepository.save(autor);
	}
}
