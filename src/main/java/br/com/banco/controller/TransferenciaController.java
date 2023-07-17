package br.com.banco.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.model.TransferenciaModel;
import br.com.banco.repository.TransferenciaRepository;

@RestController
@RequestMapping("/transferencia")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TransferenciaController {
	
	@Autowired
	private TransferenciaRepository transferenciaRepository;
	
	public TransferenciaController(TransferenciaRepository transferenciaRepository2) {
		
	}

	//retornar todos os dados de transferência.
	@GetMapping
	public ResponseEntity<List<TransferenciaModel>> getAll(){
		return ResponseEntity.ok(transferenciaRepository.findAll());
	}
	
	//Retornar todas as transferências relacionados à aquele operador.
	@GetMapping("/transferenciasOperador")
	public List<TransferenciaModel> getTransferenciasPorOperador(
		    @RequestParam(value = "operador", required = false) String operador) {

		    return transferenciaRepository.findByOperador(operador);
		}
	
	//Retornar todas as transferências relacionadas à aquele período de tempo ou
	//caso todos os filtros sejam informados, retornar todas as transferências com base no período de tempo informado e o nome do operador.
	@GetMapping("/transferenciasEspecificas")
	public List<TransferenciaModel> getTransferenciasEspecificas(
	        @RequestParam("startDate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate startDate,
	        @RequestParam("endDate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate endDate,
	        @RequestParam(value = "operador", required = false) String operador) {
	    
	    LocalDateTime startDateTime = startDate.atStartOfDay();
	    LocalDateTime endDateTime = endDate.plusDays(1).atStartOfDay();

	    if (operador != null) {
	        return transferenciaRepository.findByDataBetweenAndOperadorIgnoreCase(startDateTime, endDateTime, operador);
	    } else {
	        return transferenciaRepository.findByDataBetween(startDateTime, endDateTime);
	    }
	}

	
	
}
