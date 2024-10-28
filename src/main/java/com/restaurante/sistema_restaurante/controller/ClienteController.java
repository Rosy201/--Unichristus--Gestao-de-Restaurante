package com.restaurante.sistema_restaurante.controller;

import com.restaurante.sistema_restaurante.data.dto.ClienteDTO;
import com.restaurante.sistema_restaurante.data.dto.ClienteLowDTO;
import com.restaurante.sistema_restaurante.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cliente")
@Tag(name = "Clientes", description = "Operações relacionadas a clientes")
public class ClienteController {
    private final ClienteService clienteservice;

    @Autowired
    public ClienteController(ClienteService clienteservice) {
        this.clienteservice = clienteservice;
    }

    @Operation(summary = "Cadastra os dados de um cliente | role: [ADMIN]")

    @ApiResponses({

            @ApiResponse(responseCode = "200", description = "Usuario cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Exception não tratada")

    })
    @PostMapping
    public ClienteDTO create(@RequestBody ClienteDTO cliente) {
        return clienteservice.save(cliente);
    }

    @Operation(summary = "Atualiza os dados do cliente")

    @ApiResponses({

            @ApiResponse(responseCode = "200", description = "Usuario atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Usuario não encontrado")

    })
    @PutMapping
    public ClienteDTO update(@RequestBody ClienteDTO cliente) {
        return clienteservice.save(cliente);
    }

    @Operation(summary = "Encontra os dados do cliente")

    @ApiResponses({

            @ApiResponse(responseCode = "200", description = "Usuario encontrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Usuario não encontrado")

    })
    @GetMapping("/all")
    public List<ClienteLowDTO> findAll() {
        return clienteservice.findAll();
    }

    @Operation(summary = "Deleta os dados do cliente")

    @ApiResponses({

            @ApiResponse(responseCode = "200", description = "Usuario deletado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Usuario não encontrado")

    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clienteservice.delete(id);
    }

    @Operation(summary = "Encontra os dados do cliente")

    @ApiResponses({

            @ApiResponse(responseCode = "200", description = "Usuario encontrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Usuario não encontrado")

    })
    @GetMapping("/{id}")
    public ClienteDTO findById(@PathVariable Long id) {
        return clienteservice.findById(id);
    }
}
