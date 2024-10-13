package com.restaurante.sistema_restaurante.controller;

import com.restaurante.sistema_restaurante.data.dto.ClienteDTO;
import com.restaurante.sistema_restaurante.data.dto.ClienteLowDTO;
import com.restaurante.sistema_restaurante.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteservice;

    @PostMapping
    public ClienteDTO create(@RequestBody ClienteDTO cliente) {
        return clienteservice.save(cliente);
    }

    @PutMapping
    public ClienteDTO update(@RequestBody ClienteDTO cliente) {
        return clienteservice.save(cliente);
    }

    @GetMapping("/all")
    public List<ClienteLowDTO> findAll() {
        return clienteservice.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clienteservice.delete(id);
    }

    @GetMapping("/{id}")
    public ClienteDTO findById(@PathVariable Long id) {
        return clienteservice.findById(id);
    }


}
