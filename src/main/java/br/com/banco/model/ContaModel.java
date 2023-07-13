package br.com.banco.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "CONTA")
public class ContaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CONTA", nullable = false)
	private Long id;
	
	@Column(name = "NOME_RESPONSAVEL", nullable = false)
	private String operador;
	
	@ManyToOne
	@JsonIgnoreProperties("conta")
	private TransferenciaModel transferencia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	public TransferenciaModel getTransferencia() {
		return transferencia;
	}

	public void setTransferencia(TransferenciaModel transferencia) {
		this.transferencia = transferencia;
	}

	
	
	

}
