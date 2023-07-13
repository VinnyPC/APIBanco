package br.com.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.model.TransferenciaModel;
import br.com.banco.repository.TransferenciaRepository;

@RestController
@RequestMapping("/transferencia")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TransferenciaController {
	
	@Autowired
	private TransferenciaRepository transferenciaRepository;
	
	@GetMapping
	public ResponseEntity<List<TransferenciaModel>> getAll(){
		return ResponseEntity.ok(transferenciaRepository.findAll());
	}

	
	
}
