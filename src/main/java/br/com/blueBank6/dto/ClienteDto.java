package br.com.blueBank6.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.blueBank6.models.Cliente;
import br.com.blueBank6.models.Conta;
import br.com.blueBank6.models.Endereco;
import br.com.blueBank6.models.Rg;

public class ClienteDto {
	
	private long id;
	
	private String nomeCompleto;

	private String apelido;

	private String cpf;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	private String nomeMae;

	private BigDecimal renda;

	private String estadoCivil;

	private String escolaridade;

	private String genero;

	private String email;

	private String telefone;

	private Endereco endereco;

	private Conta conta;
	
	private Rg rg;
	
	
	
	
	public Cliente coverter() {
		return new Cliente ( id, nomeCompleto,  apelido,   cpf, dataNascimento,   nomeMae,  renda,   estadoCivil,
				  escolaridade,   genero,   email,   telefone,
				  endereco,   conta,   rg);
	}




	public long getId() {
		return id;
	}




	public void setId(long id) {
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



	

	// getters e setters
	
	



}
