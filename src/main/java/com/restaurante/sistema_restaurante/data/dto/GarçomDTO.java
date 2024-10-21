package com.restaurante.sistema_restaurante.data.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GarçomDTO {

    private int id;
    private String nome;
    private int cpf;
    private String turno;
    private int telefone;
    private BigDecimal salario;
}
