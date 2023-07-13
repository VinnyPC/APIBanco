package br.com.banco.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.model.ContaModel;
import br.com.banco.model.TransferenciaModel;
import br.com.banco.repository.ContaRepository;
import br.com.banco.repository.TransferenciaRepository;

@RestController
@RequestMapping("/conta")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContaController {
	
	@Autowired
	ContaRepository contaRepository;
	
	
	@GetMapping("/{id}")
//	public ResponseEntity<ContaModel> getById(@PathVariable Long id) {
//		Optional<ContaModel> conta = contaRepository.findById(id);
//	    if (conta.isPresent()) {
//	        return ResponseEntity.ok(conta.get());
//	    } else {
//	        return ResponseEntity.notFound().build();
//	    }
	public ResponseEntity<ContaModel> getById(@PathVariable Long id) {
		return contaRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());	
	}
	
}
