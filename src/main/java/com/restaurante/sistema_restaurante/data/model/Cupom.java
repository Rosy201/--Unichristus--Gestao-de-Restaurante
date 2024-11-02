package com.restaurante.sistema_restaurante.data.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_cupom")
@Data
public class Cupom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String codigo;
    private Double desconto;

    @ManyToOne
    private Reserva reserva;
}
