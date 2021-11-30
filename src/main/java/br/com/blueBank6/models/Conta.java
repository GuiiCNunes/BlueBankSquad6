package br.com.blueBank6.models;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name="contas")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "conta_id")
    private Long id;

    @Column(name= "numero_conta")
    private Long numeroConta;


    @Column(name ="agencia")
    @org.hibernate.annotations.ColumnDefault("100")
    private double agencia;

    @Column(name= "status")
    private Boolean status;

    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#.###00,00")
    @Column(name= "saldo")
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

    public Long getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Long numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getAgencia() {
        return agencia;
    }

    public void setAgencia(double agencia) {
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
