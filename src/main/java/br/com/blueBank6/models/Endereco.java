package br.com.blueBank6.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Enderecos")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "endereco_id")
	private Long id;

	@NotNull
	@Column(name = "cep", nullable = false, length = 8)
	private String cep;

	@NotNull
	@Column(name = "logradouro", nullable = false, length = 100)
	private String logradouro;

	@NotNull
	@Column(name = "bairro", nullable = false, length = 50)
	private String bairro;

	@NotNull
	@Column(name = "numero", nullable = false, length = 10)
	private Integer numero;

	@NotNull
	@Column(name = "cidade", nullable = false, length = 50)
	private String cidade;

	@NotNull
	@Column(name = "UF", nullable = false, length = 2)
	private String uf;

	@NotNull
	@Column(name = "pais", nullable = false, length = 30)
	private String pais;

	@Column(name = "complemento", nullable = false, length = 100)
	private String complemento;

	@Column(name = "pontoReferencia", nullable = false, length = 100)
	private String pontoReferencia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getPontoReferencia() {
		return pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}

}
