package com.restaurante.sistema_restaurante.data.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_mesa")
@Data
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;

    private Long capacidade;
    private String localizacao;
    private String status;

}
