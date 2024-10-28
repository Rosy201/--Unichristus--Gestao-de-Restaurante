package com.restaurante.sistema_restaurante.data.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PratoLowDTO {
    private Long id;
    private String name;
    private BigDecimal preco;
}
