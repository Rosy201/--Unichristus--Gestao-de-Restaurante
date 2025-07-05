package com.restaurante.sistema_restaurante.data.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_reserva")
@Data
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_hora_reserva", nullable = false)
    private LocalDateTime dataHoraReserva;

    private int quantidadePessoas;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Mesa mesa;
}
