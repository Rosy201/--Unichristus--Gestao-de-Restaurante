package com.restaurante.sistema_restaurante.controller;

import com.restaurante.sistema_restaurante.data.dto.GarcomDTO;
import com.restaurante.sistema_restaurante.data.dto.GarcomLowDTO;
import com.restaurante.sistema_restaurante.service.GarcomService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public GarcomDTO create(@RequestBody GarcomDTO garcom){
        return garcomService.save(garcom);
    }

    public GarcomDTO update(@RequestBody GarcomDTO garcom){
        return garcomService.save(garcom);
    }

    public List<GarcomLowDTO> findAll(){
        return garcomService.findAll();
    }

    public void delete(@PathVariable Long id){
        garcomService.delete(id);
    }

    public GarcomDTO findById(@PathVariable Long id){
        return garcomService.findById(id);
    }
}
