package com.restaurante.sistema_restaurante.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;

@Data
@AllArgsConstructor
public class MessageDTO {

    @Serial
    private static final long serialVersionUID = 1L;

    private String message;
    private String key;
}
