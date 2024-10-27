package com.restaurante.sistema_restaurante.controller;

import com.restaurante.sistema_restaurante.data.dto.ReservaDTO;
import com.restaurante.sistema_restaurante.data.dto.ReservaLowDTO;
import com.restaurante.sistema_restaurante.data.model.Reserva;
import com.restaurante.sistema_restaurante.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reserva")
public class ReservaController {
    
    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ReservaDTO create(@RequestBody ReservaDTO reserva) { return  reservaService.save(reserva); }

    @PutMapping("/{id}")
    public ResponseEntity <ReservaDTO> update(@PathVariable Long id, @RequestBody ReservaDTO reserva) {
        ReservaDTO updateReserva = reservaService.update(id, reserva);
        return ResponseEntity.ok(updateReserva);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ReservaLowDTO>> findAll() {
        List <ReservaLowDTO> reservas = reservaService.findAll();
        return ResponseEntity.ok(reservas);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reservaService.delete(id);
    }

    @GetMapping("/{id}")
    public ReservaDTO findById(@PathVariable Long id) {
        return reservaService.findById(id);
    }
}
