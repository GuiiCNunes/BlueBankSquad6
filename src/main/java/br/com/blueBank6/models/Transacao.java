package br.com.blueBank6.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name = "Transacoes")
public class Transacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transacao_id")
	private Long id;

	@NotNull
	@Column(name = "data_emissao", nullable = false, columnDefinition = "DATETIME")
	private LocalDateTime data;

	@Column(name = "tipo", nullable = false, length = 20)
	private String tipo;

	@NumberFormat(style = Style.CURRENCY, pattern = "#,##00.00")
	@Column(name = "valor", columnDefinition = "DECIMAL(12,2) DEFAULT 0.00")
	private BigDecimal valor;

	@ManyToOne
	@JoinColumn(name = "id_conta_origem")
	private Conta conta;

	@ManyToOne
	@JoinColumn(name = "id_conta_destino")
	private Conta destino;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo.toLowerCase();
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Conta getDestino() {
		return destino;
	}

	public void setDestino(Conta destino) {
		this.destino = destino;
	}
}