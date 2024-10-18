package com.restaurante.sistema_restaurante.service;

import com.restaurante.sistema_restaurante.data.dto.MesaDTO;
import com.restaurante.sistema_restaurante.data.dto.MesaLowDTO;
import com.restaurante.sistema_restaurante.data.model.Mesa;
import com.restaurante.sistema_restaurante.dozer.DozerConverter;
import com.restaurante.sistema_restaurante.exception.CommonsException;
import com.restaurante.sistema_restaurante.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaService {
    private final MesaRepository mesaRepository;

    @Autowired
    public MesaService(MesaRepository mesarepository){
        this.mesaRepository = mesarepository;
    }

    public MesaDTO save(MesaDTO mesa){

        //converte mesaDTO em mesa
        var entity = DozerConverter.parseObject(mesa, Mesa.class);

        //a entidade é salva no banco de dados
        var entityDTO = mesaRepository.save(entity);

        //converte e retorna a mesa em mesaDTO
        return DozerConverter.parseObject(entityDTO, MesaDTO.class);
    }

    public List <MesaLowDTO> findAll(){
        return DozerConverter.parseListObjects(mesaRepository.findAll(), MesaLowDTO.class);
    }

    public void delete(Long numeroMesa) {
        mesaRepository.deleteById(numeroMesa);
    }

    public MesaDTO findById(Long numeroMesa){
        var entity = mesaRepository.findById(numeroMesa);
        if (entity.isEmpty()){
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "restaurante.service.mesa.notfound",
                    "o numero da mesa informado não foi encontrado");
        }
        return DozerConverter.parseObject(entity.get(), MesaDTO.class);
    }
}
