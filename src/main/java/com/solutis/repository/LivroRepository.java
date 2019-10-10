package com.solutis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solutis.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
