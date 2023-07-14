package br.com.banco.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.banco.model.TransferenciaModel;

public interface TransferenciaRepository extends JpaRepository<TransferenciaModel, Long>{
	
	List<TransferenciaModel> findByContaIdConta(Long idConta);
	
	@Query("SELECT t FROM TransferenciaModel t WHERE t.data BETWEEN :startDate AND :endDate")
	List<TransferenciaModel> findByDataBetween(LocalDateTime startDate, LocalDateTime endDate);
	
	@Query("SELECT t FROM TransferenciaModel t WHERE lower(t.operador) = COALESCE(lower(:operador), lower(t.operador))")
	List<TransferenciaModel> findByOperador(@Param("operador") String operador);

	public List<TransferenciaModel> findByDataBetweenAndOperadorIgnoreCase(LocalDateTime startDateTime, LocalDateTime endDateTime, String operador);

}
