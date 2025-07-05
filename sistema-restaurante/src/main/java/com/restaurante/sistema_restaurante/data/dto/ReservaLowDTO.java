package com.restaurante.sistema_restaurante.data.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservaLowDTO {
    private Long id;
    private LocalDateTime dataHoraReserva;
    private ClienteLowDTO cliente;
    private MesaLowDTO mesa;
}
