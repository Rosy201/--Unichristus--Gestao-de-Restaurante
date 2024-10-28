package com.restaurante.sistema_restaurante.data.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PratoDTO {

    private Long id;
    private String name;
    private BigDecimal preco;
    private String categoria;
    private String tipoCozinha;
}
