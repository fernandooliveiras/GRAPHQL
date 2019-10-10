package com.solutis.resolver.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.solutis.exceptions.LivroException;
import com.solutis.model.Autor;
import com.solutis.model.Livro;
import com.solutis.repository.LivroRepository;

@Component
public class MutationLivro implements GraphQLMutationResolver {
	
	private LivroRepository livroRepository;
	
	@Autowired
	public MutationLivro (LivroRepository livroRepository) {
		super();
		this.livroRepository = livroRepository;
	}
	
	
	public Livro novoLivro(String titulo, Integer numeroPaginas, Long autorId) {
		
		Livro livro = new Livro();
		livro.setAutor(new Autor(autorId));
		livro.setTitulo(titulo);
		livro.setNumeroPaginas(numeroPaginas != null ? numeroPaginas : 0);

        livroRepository.save(livro);

        return livro;
    }
	
	public boolean deleteLivro(Long id) {
		
        livroRepository.deleteById(id);;
        return true;
    }
	
	public Livro updateLivroNumeroPaginas(Integer paginas, Long id) {
		
		Livro livro = livroRepository.findById(id).get();
		
		if (livro == null)
			throw new LivroException("ID do livro inválido", id);
		
		livro.setNumeroPaginas(paginas);

		livroRepository.save(livro);

        return livro;
    }
	
}
