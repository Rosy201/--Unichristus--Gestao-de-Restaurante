package com.restaurante.sistema_restaurante.controller;

import com.restaurante.sistema_restaurante.data.dto.ReservaDTO;
import com.restaurante.sistema_restaurante.data.dto.ReservaLowDTO;
import com.restaurante.sistema_restaurante.service.ReservaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reserva")
@Tag(name = "Reservas", description = "Operacoes relacionada a reserva")
public class ReservaController {
    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @Operation(summary = "Cadastra os dados de uma reserva | role: [ADMIN]")

    @ApiResponses({

            @ApiResponse(responseCode = "200", description = "Reserva cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Exception não tratada")

    })
    @PostMapping
    public ReservaDTO create(@RequestBody ReservaDTO reserva) { return  reservaService.save(reserva); }

    @Operation(summary = "Atualiza os dados da reserva")

    @ApiResponses({

            @ApiResponse(responseCode = "200", description = "Reserva atualizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Reserva não encontrada")

    })
    @PutMapping("/{id}")
    public ResponseEntity <ReservaDTO> update(@PathVariable Long id, @RequestBody ReservaDTO reserva) {
        ReservaDTO updateReserva = reservaService.update(id, reserva);
        return ResponseEntity.ok(updateReserva);
    }

    @Operation(summary = "Encontra os dados da reserva")

    @ApiResponses({

            @ApiResponse(responseCode = "200", description = "Reserva encontrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Reserva não encontrado")

    })
    @GetMapping("/all")
    public ResponseEntity<List<ReservaLowDTO>> findAll() {
        List <ReservaLowDTO> reservas = reservaService.findAll();
        return ResponseEntity.ok(reservas);
    }

    @Operation(summary = "Deleta os dados da reserva")

    @ApiResponses({

            @ApiResponse(responseCode = "200", description = "Reserva deletada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Reserva não encontrado")

    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reservaService.delete(id);
    }

    @Operation(summary = "Encontra os dados da reserva")

    @ApiResponses({

            @ApiResponse(responseCode = "200", description = "Reserva encontrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Reserva não encontrado")

    })
    @GetMapping("/{id}")
    public ReservaDTO findById(@PathVariable Long id) {
        return reservaService.findById(id);
    }
}
