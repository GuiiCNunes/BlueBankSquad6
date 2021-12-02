package br.com.blueBank6.models;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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

	@Column(name = "tipo", nullable = false, length = 10)
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