package com.restaurante.sistema_restaurante.service;

import com.restaurante.sistema_restaurante.data.dto.PratoDTO;
import com.restaurante.sistema_restaurante.data.dto.PratoLowDTO;
import com.restaurante.sistema_restaurante.data.model.Prato;
import com.restaurante.sistema_restaurante.dozer.DozerConverter;
import com.restaurante.sistema_restaurante.exception.CommonsException;
import com.restaurante.sistema_restaurante.repository.PratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PratoService {

    private final PratoRepository pratoRepository;

    @Autowired
    public PratoService(PratoRepository pratoRepository) {
        this.pratoRepository = pratoRepository;
    }

    public PratoDTO save(PratoDTO prato){
        var entity = DozerConverter.parseObject(prato, Prato.class);

        var entityDTO = pratoRepository.save(entity);

        return DozerConverter.parseObject(entityDTO, PratoDTO.class);
    }

    public List<PratoLowDTO> findAll() {
        return DozerConverter.parseListObjects(
                pratoRepository.findAll(), PratoLowDTO.class
        );
    }

    public void delete(Long id){
        pratoRepository.deleteById(id);
    }

    public PratoDTO findById(Long id){
        var entity = pratoRepository.findById(id);
        if (entity.isEmpty()){
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "restaurante.service.cliente.notfound",
                    "o ID do prato não foi encontrado");
        }
        return DozerConverter.parseObject(entity.get(), PratoDTO.class);
    }

}
