package br.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.model.Fornecedores;

public interface FornecedoresRepository extends JpaRepository<Fornecedores, Long> {

	
	public List<Fornecedores> findByNomeContaining(String nome);
}