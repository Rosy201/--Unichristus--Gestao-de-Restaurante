package com.restaurante.sistema_restaurante.data.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_cliente")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    
    private Long login;
    private Long password;
}
