package com.restaurante.sistema_restaurante.service;

import com.restaurante.sistema_restaurante.data.dto.ClienteDTO;
import com.restaurante.sistema_restaurante.data.dto.ClienteLowDTO;
import com.restaurante.sistema_restaurante.data.model.Cliente;
import com.restaurante.sistema_restaurante.dozer.DozerConverter;
import com.restaurante.sistema_restaurante.exception.CommonsException;
import com.restaurante.sistema_restaurante.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienterepository;

    @Autowired
    public ClienteService(ClienteRepository clienterepository){
        this.clienterepository = clienterepository;
    }

    public ClienteDTO save(ClienteDTO cliente) {
        if (cliente.getName().length() > 150) {
            System.out.println("Limite de caracteres de nome atigindo");
            return null;
        }

        //converte clienteDTO em cliente
        var entity = DozerConverter.parseObject(cliente, Cliente.class);

        //a entidade é salva no banco de dados
        var entityDTO = clienterepository.save(entity);

        //converte e retorna o cliente em clienteDTO
        return DozerConverter.parseObject(entityDTO, ClienteDTO.class);
    }

    public List <ClienteLowDTO> findAll(){
        return DozerConverter.parseListObjects(
                clienterepository.findAll(), ClienteLowDTO.class);
    }

    public void delete(Long id){
        clienterepository.deleteById(id);
    }

    public ClienteDTO findById(Long id){
        var entity = clienterepository.findById(id);
        if (entity.isEmpty()){
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "restaurante.service.cliente.notfound",
                    "O usuario com o ID informado, não foi encontrado");
        }
        return DozerConverter.parseObject(entity.get(), ClienteDTO.class);
    }


}






