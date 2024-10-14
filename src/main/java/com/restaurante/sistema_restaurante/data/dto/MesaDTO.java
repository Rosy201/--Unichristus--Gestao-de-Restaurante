package com.restaurante.sistema_restaurante.data.dto;

import lombok.Data;

@Data
public class MesaDTO {


    private Long numero;
    private Long capacidade;
    private String localizacao;
    private String status;

}
