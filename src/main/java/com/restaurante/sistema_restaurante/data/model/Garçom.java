package com.restaurante.sistema_restaurante.data.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_garçom")
@Data
public class Garçom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cpf", nullable = false)
    private int cpf;

    private String turno;
    private int telefone;

    @Column(name = "salario", nullable = false, precision = 10, scale = 2)
    private BigDecimal salario;
}
