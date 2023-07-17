package br.com.banco.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	TransferenciaRepository transferenciaRepository;
	
	@GetMapping
	public ResponseEntity<List<ContaModel>> getAll(){
		return ResponseEntity.ok(contaRepository.findAll());
	}
	
	//fornece os dados de transferência de acordo com o número da conta bacária
	@GetMapping("/{idConta}/transferencias")
	public List<TransferenciaModel> getTransferenciasByContaId(@PathVariable Long idConta) {
        return transferenciaRepository.findByContaIdConta(idConta);
    }
	
	
	
	
}
