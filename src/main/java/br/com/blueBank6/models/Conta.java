package br.com.blueBank6.models;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;

@Controller
@Entity
@Table(name = "contas")
public class Conta {
	
	public Conta() {
		
	}
	
	public Conta(Long id, int numeroConta, String agencia, Boolean status, BigDecimal saldo) {
		this.id = id;
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		this.status = status;
		this.saldo = saldo;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "conta_id")
	private Long id;

	@Column(name = "numero_conta", length = 15)
	private int numeroConta;

	@Column(name = "agencia", length = 5, nullable = false)
	private String agencia = "0001";

	@Column(name = "status")
	private Boolean status = true;

	@NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#.###00,00")
	private BigDecimal saldo = new BigDecimal(0);

	@NotNull
	@Column(length = 8, nullable = false)
	private int senha;

	
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

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

}