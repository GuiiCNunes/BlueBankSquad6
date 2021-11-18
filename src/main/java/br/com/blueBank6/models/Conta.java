package br.com.blueBank6.models;

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
    @Column(name= "saldo", nullable = false)
    private BigDecimal saldo;

    @NotNull
    @Column(length = 6, nullable = false)
    private int senha;



}
