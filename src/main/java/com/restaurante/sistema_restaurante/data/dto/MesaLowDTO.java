package com.restaurante.sistema_restaurante.data.dto;

import lombok.Data;

@Data
public class MesaLowDTO {
    private Long numeroMesa;
    private Long capacidade;
    private String localizacao;
    private String disponibilidade;
}

