package com.restaurante.sistema_restaurante.exception;

import com.restaurante.sistema_restaurante.data.dto.MessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serial;

public class CommonsException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = -4694258578216919456L;

    protected HttpStatus status;
    protected String key;
    protected String text;


    public ResponseEntity<MessageDTO> getMessageError() {
        return ResponseEntity.status(status).body(new MessageDTO(text, key));
    }
}
