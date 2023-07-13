package br.com.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banco.model.TransferenciaModel;

public interface TransferenciaRepository extends JpaRepository<TransferenciaModel, Long>{
	
	

}
