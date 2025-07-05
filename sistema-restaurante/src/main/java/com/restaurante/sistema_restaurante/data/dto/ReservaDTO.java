package com.restaurante.sistema_restaurante.data.dto;

import com.restaurante.sistema_restaurante.data.model.Cliente;
import com.restaurante.sistema_restaurante.data.model.Mesa;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservaDTO {
    private Long id;
    private LocalDateTime dataHoraReserva;
    private int quantidadePessoas;
    private ClienteLowDTO cliente;
    private MesaLowDTO mesa;
}
