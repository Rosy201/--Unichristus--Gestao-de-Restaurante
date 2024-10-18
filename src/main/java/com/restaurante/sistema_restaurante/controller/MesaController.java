package com.restaurante.sistema_restaurante.controller;

import com.restaurante.sistema_restaurante.data.dto.MesaDTO;
import com.restaurante.sistema_restaurante.data.dto.MesaLowDTO;
import com.restaurante.sistema_restaurante.service.MesaService;
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

    @PostMapping
    public MesaDTO create(@RequestBody MesaDTO mesa){
        return mesaService.save(mesa);
    }

    @PutMapping("/{numeroMesa}")
    public MesaDTO update(@RequestBody MesaDTO mesa) { return mesaService.save(mesa); }

    @GetMapping("/all")
    public List<MesaLowDTO> findAll(){
        return mesaService.findAll();
    }

    @DeleteMapping("/{numeroMesa}")
    public void delete(@PathVariable Long numeroMesa){
        mesaService.delete(numeroMesa);
    }

    @GetMapping("/{numeroMesa}")
    public MesaDTO findById(@PathVariable Long numeroMesa){
        return mesaService.findById(numeroMesa);
    }

}
