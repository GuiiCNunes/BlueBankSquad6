package br.com.blueBank6.models;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name="contas")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "conta_id")
    private Long conta;

    @NotNull
    @Column(name= "numero", length = 15, nullable = false)
    private String numero;

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
    @Column(length = 6, nullable = false)
    private int senha;

    public Long getConta() {
        return conta;
    }

    public void setConta(Long conta) {
        this.conta = conta;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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
