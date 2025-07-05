package com.restaurante.sistema_restaurante.controller;

import com.restaurante.sistema_restaurante.data.dto.GarcomDTO;
import com.restaurante.sistema_restaurante.data.dto.GarcomLowDTO;
import com.restaurante.sistema_restaurante.service.GarcomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/garcom")
@Tag(name = "Garçom", description = "Operações relacionadas a garçom")
public class GarcomController {
    private final GarcomService garcomService;

    @Autowired
    public GarcomController(GarcomService garcomService) {
        this.garcomService = garcomService;
    }

    @Operation(summary = "Cadastra os dados de um garçom | role: [ADMIN]")

    @ApiResponses({

            @ApiResponse(responseCode = "200", description = "Garçom cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Exception não tratada")

    })
    @PostMapping
    public GarcomDTO create(@RequestBody GarcomDTO garcom){
        return garcomService.save(garcom);
    }

    @Operation(summary = "Atualiza os dados do garçom")

    @ApiResponses({

            @ApiResponse(responseCode = "200", description = "Garçom atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Garçom não encontrado")

    })
    @PutMapping
    public GarcomDTO update(@RequestBody GarcomDTO garcom){
        return garcomService.save(garcom);
    }

    @Operation(summary = "Encontra os dados do garçom")

    @ApiResponses({

            @ApiResponse(responseCode = "200", description = "Garçom encontrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Garçom não encontrado")

    })
    @GetMapping("/all")
    public List<GarcomLowDTO> findAll(){
        return garcomService.findAll();
    }

    @Operation(summary = "Deleta os dados do garçom")

    @ApiResponses({

            @ApiResponse(responseCode = "200", description = "Garçom deletado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Garçom não encontrado")

    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        garcomService.delete(id);
    }

    @Operation(summary = "Encontra os dados do garçom")

    @ApiResponses({

            @ApiResponse(responseCode = "200", description = "Garçom encontrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Garçom não encontrado")

    })
    @GetMapping("/{id}")
    public GarcomDTO findById(@PathVariable Long id){
        return garcomService.findById(id);
    }
}
