package br.com.blueBank6.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "Transacao")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rg_id")
    private Long id;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "data_emissao",nullable = false, columnDefinition = "DATE")
    private LocalDate data;

    @Column(name="tipo", nullable = false, length = 10)
    private String tipo;

    private float valor;

    @ManyToOne
    @JoinColumn(name = "id_conta_origem_fk")
    private Conta conta_origem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Conta getConta_origem() {
        return conta_origem;
    }

    public void setConta_origem(Conta conta_origem) {
        this.conta_origem = conta_origem;
    }
}