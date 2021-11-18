package br.com.blueBank6.models;

import javax.persistence.*;

@Entity
@Table(name="conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "conta")
    private Long conta;
    
    @Column(name= "numero", length = 45)
    private String numero;

    @Column(name ="agencia", length = 45)
    private String agencia;

    @Column(name= "status")
    private Boolean status;

    @Column(name= "saldo")
    private float saldo;

    @Column(length = 45)
    private String senha;

    // Conta deve ter referencia à cliente? (cliente_id)

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

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
