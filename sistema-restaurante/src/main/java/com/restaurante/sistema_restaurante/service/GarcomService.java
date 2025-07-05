package com.restaurante.sistema_restaurante.service;

import com.restaurante.sistema_restaurante.data.dto.GarcomDTO;
import com.restaurante.sistema_restaurante.data.dto.GarcomLowDTO;
import com.restaurante.sistema_restaurante.data.model.Garcom;
import com.restaurante.sistema_restaurante.dozer.DozerConverter;
import com.restaurante.sistema_restaurante.exception.CommonsException;
import com.restaurante.sistema_restaurante.repository.GarcomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarcomService {

    private final GarcomRepository garcomRepository;

    @Autowired
    public GarcomService(GarcomRepository garcomRepository) {
        this.garcomRepository = garcomRepository;
    }

    public GarcomDTO save(GarcomDTO garcom){
        var entity = DozerConverter.parseObject(garcom, Garcom.class);

        var entityDTO = garcomRepository.save(entity);

        return DozerConverter.parseObject(entityDTO, GarcomDTO.class);
    }

    public List <GarcomLowDTO> findAll(){
        return DozerConverter.parseListObjects(
                garcomRepository.findAll(), GarcomLowDTO.class);
    }

    public void delete(Long id){
        garcomRepository.deleteById(id);
    }

    public GarcomDTO findById(Long id){
        var entity = garcomRepository.findById(id);
        if (entity.isEmpty()){
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "restaurante.service.garcom.notfound",
                    "o ID de garcom informado não foi encontrado");
        }
        return DozerConverter.parseObject(entity.get(), GarcomDTO.class);
    }
}
