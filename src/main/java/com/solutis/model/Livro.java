package com.solutis.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private Integer paginas;
	
	@ManyToOne
    @JoinColumn(name = "author_id",
            nullable = false, updatable = false)
	private Autor autor;

	@ManyToMany
	@JoinTable(
			name = "bibliotecas_livros",
			joinColumns = @JoinColumn(name = "livro_id"),
			inverseJoinColumns = @JoinColumn(name = "biblioteca_id"))
	private List<Biblioteca> bibliotecas;


	public Livro() {
		
	}
	
	public Livro(String titulo, String isbn, Integer paginas, Autor autor) {
		super();
		this.titulo = titulo;
		this.paginas = paginas;
		this.autor = autor;
	}

	public Livro(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getNumeroPaginas() {
		return paginas;
	}
	public void setNumeroPaginas(Integer paginas) {
		this.paginas = paginas;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	  
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
	      if (obj == null || getClass() != obj.getClass()) return false;

	      Livro livro = (Livro) obj;

	      return id.equals(livro.id);
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo +", numeroPaginas=" + paginas
				+ ", autor=" + autor + "]";
	}
	
	
}
