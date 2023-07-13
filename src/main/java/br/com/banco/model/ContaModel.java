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
	@Column(name = "id_conta")
	private Long idConta;

	@Column(name = "nome_responsavel", nullable = false)
	private String nomeResponsavel;

//	@ManyToOne
//	@JsonIgnoreProperties("conta")
//	private TransferenciaModel transferenciaModel;

	public Long getIdConta() {
		return idConta;
	}

	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

//	public TransferenciaModel getTransferenciaModel() {
//		return transferenciaModel;
//	}
//
//	public void setTransferenciaModel(TransferenciaModel transferenciaModel) {
//		this.transferenciaModel = transferenciaModel;
//	}

	

}
