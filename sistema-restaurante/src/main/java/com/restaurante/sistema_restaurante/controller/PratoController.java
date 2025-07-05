package com.restaurante.sistema_restaurante.controller;

import com.restaurante.sistema_restaurante.data.dto.PratoDTO;
import com.restaurante.sistema_restaurante.data.dto.PratoLowDTO;
import com.restaurante.sistema_restaurante.service.PratoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/prato")
@Tag(name = "Pratos", description = "Operações relacionadas a prato")
public class PratoController {
    private final PratoService pratoService;

    @Autowired
    public PratoController(PratoService pratoService) {
        this.pratoService = pratoService;
    }

    @Operation(summary = "Cadastra os dados de um prato | role: [ADMIN]")

    @ApiResponses({

            @ApiResponse(responseCode = "200", description = "Prato cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Exception não tratada")

    })
    @PostMapping
    public PratoDTO create(@RequestBody PratoDTO prato){
        return pratoService.save(prato);
    }

    @Operation(summary = "Atualiza os dados do prato")

    @ApiResponses({

            @ApiResponse(responseCode = "200", description = "Prato atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Prato não encontrado")

    })
    @PutMapping
    public PratoDTO update(@RequestBody PratoDTO prato){
        return pratoService.save(prato);
    }

    @Operation(summary = "Encontra os dados do prato")

    @ApiResponses({

            @ApiResponse(responseCode = "200", description = "Prato encontrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Prato não encontrado")

    })
    @GetMapping("/all")
    public List<PratoLowDTO> findAll(){
        return pratoService.findAll();
    }

    @Operation(summary = "Deleta os dados do prato")

    @ApiResponses({

            @ApiResponse(responseCode = "200", description = "Prato deletado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Prato não encontrado")

    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        pratoService.delete(id);
    }

    @Operation(summary = "Encontra os dados do prato")

    @ApiResponses({

            @ApiResponse(responseCode = "200", description = "Prato encontrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Prato não encontrado")

    })
    @GetMapping("/{id}")
    public PratoDTO findById(@PathVariable Long id){
        return pratoService.findById(id);
    }
}
