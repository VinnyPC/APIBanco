package br.com.banco.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "TRANSFERENCIA")
public class TransferenciaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;
	
	@Column(name = "nome_operador_transacao")
	private String operador;

	//@UpdateTimestamp
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@Column(name = "DATA_TRANSFERENCIA", nullable = false)
	private LocalDateTime data;

	@Column(name = "VALOR", nullable = false)
	private BigDecimal valor;

	@Column(name = "TIPO", nullable = false)
	private String tipo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conta_id", nullable = false)
	private ContaModel conta;
	
	public TransferenciaModel(Long id, String operador, LocalDateTime data, BigDecimal valor, String tipo) {
		super();
		this.id = id;
		this.operador = operador;
		this.data = data;
		this.valor = valor;
		this.tipo = tipo;
	}
	
	

	public TransferenciaModel() {
	}



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

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public ContaModel getConta() {
		return conta;
	}

	public void setConta(ContaModel conta) {
		this.conta = conta;
	}

	

}
