package com.restaurante.sistema_restaurante.controller;

import com.restaurante.sistema_restaurante.data.dto.MesaDTO;
import com.restaurante.sistema_restaurante.data.dto.MesaLowDTO;
import com.restaurante.sistema_restaurante.service.MesaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mesa")
public class MesaController {

    private final MesaService mesaService;

    @Autowired
    public MesaController(MesaService mesaService) {
        this.mesaService = mesaService;
    }

    @Operation(summary = "Cadastra os dados de uma mesa | role: [ADMIN]",
            tags = "Mesa")

    @ApiResponses({

            @ApiResponse(responseCode = "200", description = "Mesa cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Exception não tratada")

    })
    @PostMapping
    public MesaDTO create(@RequestBody MesaDTO mesa){
        return mesaService.save(mesa);
    }

    @Operation(summary = "Atualiza os dados da mesa",
            tags = "MesaAtualiza")

    @ApiResponses({

            @ApiResponse(responseCode = "200", description = "Mesa atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Mesa não encontrada")

    })
    @PutMapping("/{numeroMesa}")
    public MesaDTO update(@RequestBody MesaDTO mesa) { return mesaService.save(mesa); }

    @Operation(summary = "Encontra os dados da mesa",
            tags = "MesaProcurar")

    @ApiResponses({

            @ApiResponse(responseCode = "200", description = "Mesa encontrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Mesa não encontrada")

    })
    @GetMapping("/all")
    public List<MesaLowDTO> findAll(){
        return mesaService.findAll();
    }

    @Operation(summary = "Deleta os dados da mesa",
            tags = "MesaDeletada")

    @ApiResponses({

            @ApiResponse(responseCode = "200", description = "Mesa deletada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Mesa não encontrada")

    })
    @DeleteMapping("/{numeroMesa}")
    public void delete(@PathVariable Long numeroMesa){
        mesaService.delete(numeroMesa);
    }

    @Operation(summary = "Encontra os dados da mesa",
            tags = "MesaAllDados")

    @ApiResponses({

            @ApiResponse(responseCode = "200", description = "Mesa encontrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Mesa não encontrada")

    })
    @GetMapping("/{numeroMesa}")
    public MesaDTO findById(@PathVariable Long numeroMesa){
        return mesaService.findById(numeroMesa);
    }

}
