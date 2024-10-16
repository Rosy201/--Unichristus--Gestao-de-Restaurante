package com.restaurante.sistema_restaurante.data.dto;

import lombok.Data;

@Data
public class ClienteDTO {

    private Long id;
    private String name;
    private String email;
    private String login;
    private String password;
}
