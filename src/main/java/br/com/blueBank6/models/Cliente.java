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
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cliente_id")
	private Long id;	
	
	@NotNull
	@Column(name = "nome_completo", nullable = false, length = 50)
	private String nomeCompleto;

  @Nullable
	@Column(name = "apelido", nullable = true, length = 20)
	private String apelido;

	@CPF
  @NotNull
	@Column(name = "cpf", nullable = false, length = 14)
	private String cpf;
	
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_nascimento",nullable = false, columnDefinition = "DATE")
	private LocalDate dataNascimento;
	
	@NotNull
	@Column(name = "nome_mae", nullable = false, length = 50)
	private String nomeMae;

	@Valid
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_rg_fk", nullable = false)
  private Rg rg;

	@NumberFormat(style = Style.CURRENCY, pattern = "#,##00.00")
  @NotNull
	@Column(name = "renda", nullable = false, columnDefinition = "DECIMAL(12,2) DEFAULT 0.00")
	private String renda;

  @NotNull
	@Column(name = "estado_civil", nullable = false, length = 10)
	private String estadoCivil;

  @NotNull
	@Column(name = "escolaridade", nullable = false, length = 50)
	private String escolaridade;

	@Valid
  @OneToOne (cascade = CascadeType.ALL)
  @JoinColumn(name = "id_endereco_fk", nullable = false)
  private Endereco endereco;

	@Valid
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_conta_fk", nullable = false)
  private Conta conta;

  @NotNull
	@Column(name = "genero", nullable = false, length = 50)
	private String genero;

	@Email
  @NotNull
	@Column(name = "email", nullable = false, length = 50)
	private String email;

  @NotNull
	@Column(name = "telefone", nullable = false, length = 20)
	private String telefone;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return this.nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getApelido() {
		return this.apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNomeMae() {
		return this.nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public Rg getRg() {
		return this.rg;
	}

	public void setRg(Rg rg) {
		this.rg = rg;
	}

	public String getRenda() {
		return this.renda;
	}

	public void setRenda(String renda) {
		this.renda = renda;
	}

	public String getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEscolaridade() {
		return this.escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Conta getConta() {
		return this.conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Cliente id(Long id) {
		setId(id);
		return this;
	}

	public Cliente nomeCompleto(String nomeCompleto) {
		setNomeCompleto(nomeCompleto);
		return this;
	}

	public Cliente apelido(String apelido) {
		setApelido(apelido);
		return this;
	}

	public Cliente cpf(String cpf) {
		setCpf(cpf);
		return this;
	}

	public Cliente dataNascimento(LocalDate dataNascimento) {
		setDataNascimento(dataNascimento);
		return this;
	}

	public Cliente nomeMae(String nomeMae) {
		setNomeMae(nomeMae);
		return this;
	}

	public Cliente rg(Rg rg) {
		setRg(rg);
		return this;
	}

	public Cliente renda(String renda) {
		setRenda(renda);
		return this;
	}

	public Cliente estadoCivil(String estadoCivil) {
		setEstadoCivil(estadoCivil);
		return this;
	}

	public Cliente escolaridade(String escolaridade) {
		setEscolaridade(escolaridade);
		return this;
	}

	public Cliente endereco(Endereco endereco) {
		setEndereco(endereco);
		return this;
	}

	public Cliente conta(Conta conta) {
		setConta(conta);
		return this;
	}

	public Cliente genero(String genero) {
		setGenero(genero);
		return this;
	}

	public Cliente email(String email) {
		setEmail(email);
		return this;
	}

	public Cliente telefone(String telefone) {
		setTelefone(telefone);
		return this;
	}

}
