package br.com.blueBank6.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "rg")
public class Rg {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rg_id")
	private Long id;
	
	
	@Nullable
	@Column(name = "numero_rg", nullable = false, length = 30)
	private String numeroRg;
	
	@Nullable
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_emissao",nullable = false, columnDefinition = "DATE")
	private LocalDate dataEmissao;
	
	@Nullable
	@Column(name = "orgao_emissor", nullable = false, length = 10)
	private String orgaoEmissor;
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroRg() {
		return numeroRg;
	}

	public void setNumeroRg(String numeroRg) {
		this.numeroRg = numeroRg;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}

	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
	}
	
	
	
	

}
