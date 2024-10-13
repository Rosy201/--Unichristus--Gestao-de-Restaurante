package com.restaurante.sistema_restaurante.service;

import com.restaurante.sistema_restaurante.data.dto.ClienteDTO;
import com.restaurante.sistema_restaurante.data.model.Cliente;
import com.restaurante.sistema_restaurante.dozer.DozerConverter;
import com.restaurante.sistema_restaurante.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}