package com.restaurante.sistema_restaurante.data.dto;

import lombok.Data;

@Data
public class MesaDTO {
    private Long numeroMesa;
    private Long capacidade;
    private String localizacao;
    private String disponibilidade;
    private String reservadaPara;
}
