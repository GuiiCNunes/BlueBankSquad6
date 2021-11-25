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

@Entity
@Table(name="contas")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "conta_id")
    private Long id;

    @NotNull
    @Column(name= "numero_conta", length = 15, nullable = false)
    private String numeroConta;

    @NotNull
    @Column(name ="agencia", length = 5, nullable = false)
    private String agencia;


    @Column(name= "status")
    private Boolean status;

    @NotNull
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#.###00,00")
    @Column(name= "saldo", nullable = false, columnDefinition = "DECIMAL(12,2) DEFAULT 0.00")
    private BigDecimal saldo;

    @NotNull
    @Column(length = 8, nullable = false)
    private int senha;
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
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
