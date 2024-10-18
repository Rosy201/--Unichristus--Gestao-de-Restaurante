package com.restaurante.sistema_restaurante.data.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_mesa")
@Data
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroMesa;

    private Long capacidade;
    private String localizacao;
    private String disponibilidade;
    private String reservadaPara;

}
