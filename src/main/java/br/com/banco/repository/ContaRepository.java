package br.com.banco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import br.com.banco.model.ContaModel;

public interface ContaRepository extends JpaRepository<ContaModel, Long> {
	
	//public List<ContaModel> findAllOperadorContainingIgnoreCase(@Param("operador") String operador);

}
