package br.com.blueBank6.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "clientes")
public class Cliente {

	public Cliente() {
	}

	public Cliente(Long id, String nomeCompleto, String apelido, String cpf, LocalDate dataNascimento, String nomeMae,
			BigDecimal renda, String estadoCivil, String escolaridade, String genero, String email, String telefone,
			Endereco endereco, Conta conta, Rg rg) {

		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.apelido = apelido;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.nomeMae = nomeMae;
		this.renda = renda;
		this.estadoCivil = estadoCivil;
		this.escolaridade = escolaridade;
		this.genero = genero;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.conta = conta;
		this.rg = rg;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cliente_id")
	private Long id;

	@NotNull
	@Column(name = "nome_completo", nullable = false, length = 50)
	private String nomeCompleto;

	@Column(name = "apelido", nullable = true, length = 20)
	private String apelido;

	@CPF
	@Column(name = "cpf", nullable = false, length = 14, unique = true)
	private String cpf;

	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_nascimento", nullable = false, columnDefinition = "DATE")
	private LocalDate dataNascimento;

	@NotNull
	@Column(name = "nome_mae", nullable = false, length = 50)
	private String nomeMae;

	@NumberFormat(style = Style.CURRENCY, pattern = "#,##00.00")
	@Column(name = "renda", columnDefinition = "DECIMAL(12,2) DEFAULT 0.00")
	private BigDecimal renda;

	@NotNull
	@Column(name = "estado_civil", nullable = false, length = 10)
	private String estadoCivil;

	@NotNull
	@Column(name = "escolaridade", nullable = false, length = 50)
	private String escolaridade;

	@NotNull
	@Column(name = "genero", nullable = false, length = 50)
	private String genero;

	@Email
	@Column(name = "email", nullable = false, length = 50)
	private String email;

	@NotNull
	@Column(name = "telefone", nullable = false, length = 20)
	private String telefone;

	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id", nullable = false)
	private Endereco endereco;

	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "conta_id", nullable = false)
	private Conta conta;

	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rg_id", nullable = false)
	private Rg rg;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public BigDecimal getRenda() {
		return renda;
	}

	public void setRenda(BigDecimal renda) {
		this.renda = renda;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Rg getRg() {
		return rg;
	}

	public void setRg(Rg rg) {
		this.rg = rg;
	}

}
