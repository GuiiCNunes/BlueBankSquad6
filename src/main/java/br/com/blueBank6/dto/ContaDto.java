package br.com.blueBank6.dto;

import java.math.BigDecimal;

import br.com.blueBank6.models.Conta;

public class ContaDto {

	private Long id;
	private int numeroConta;
	private String agencia;
	private Boolean status;
	private BigDecimal saldo;

	public Conta converter() {
		return new Conta(id, numeroConta, agencia, status, saldo);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

}
