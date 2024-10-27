package com.restaurante.sistema_restaurante.service;

import com.restaurante.sistema_restaurante.data.dto.ReservaDTO;
import com.restaurante.sistema_restaurante.data.dto.ReservaLowDTO;
import com.restaurante.sistema_restaurante.data.model.Cliente;
import com.restaurante.sistema_restaurante.data.model.Mesa;
import com.restaurante.sistema_restaurante.data.model.Reserva;
import com.restaurante.sistema_restaurante.dozer.DozerConverter;
import com.restaurante.sistema_restaurante.exception.CommonsException;
import com.restaurante.sistema_restaurante.repository.ClienteRepository;
import com.restaurante.sistema_restaurante.repository.MesaRepository;
import com.restaurante.sistema_restaurante.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final ClienteRepository clienteRepository;
    private final MesaRepository mesaRepository;

    @Autowired
    public ReservaService(ReservaRepository reservarepository, ClienteRepository clienteRepository, MesaRepository mesaRepository) {
        this.reservaRepository = reservarepository;
        this.clienteRepository = clienteRepository;
        this.mesaRepository = mesaRepository;
    }
    public ReservaDTO save(ReservaDTO reserva){
        Cliente cliente = clienteRepository.findById(reserva.getCliente().getId())
                .orElseThrow(() -> new CommonsException(HttpStatus.NOT_FOUND,
                        "restaurante.service.cliente.notfound",
                        "Id de Cliente não encontrado"));

        Mesa mesa = mesaRepository.findById(reserva.getMesa().getNumeroMesa())
                .orElseThrow(() -> new CommonsException(HttpStatus.NOT_FOUND,
                        "restaurante.service.mesa.notfound",
                        "Id de mesa não encontrado"));

        var entity = DozerConverter.parseObject(reserva, Reserva.class);

        entity.setCliente(cliente);
        entity.setMesa(mesa);
        
        var entityDTO = reservaRepository.save(entity);

        return DozerConverter.parseObject(entityDTO, ReservaDTO.class);
    }

    public ReservaDTO update(Long id, ReservaDTO reserva){
        Reserva reservaExistente = reservaRepository.findById(id)
                .orElseThrow(() -> new CommonsException(HttpStatus.NOT_FOUND,
                        "restaurante.service.reserva.notfound",
                        "ID da reserva nao encontrado"));

        reservaExistente.setDataHoraReserva(reserva.getDataHoraReserva());
        reservaExistente.setQuantidadePessoas(reserva.getQuantidadePessoas());

        Cliente cliente = clienteRepository.findById(reserva.getCliente().getId())
                .orElseThrow(() -> new CommonsException(HttpStatus.NOT_FOUND,
                        "restaurante.service.cliente.notfound",
                        "Id de Cliente não encontrado"));
        reservaExistente.setCliente(cliente);

        Mesa mesa = mesaRepository.findById(reserva.getMesa().getNumeroMesa())
                .orElseThrow(() -> new CommonsException(HttpStatus.NOT_FOUND,
                        "restaurante.service.mesa.notfound",
                        "Id de mesa não encontrado"));
        reservaExistente.setMesa(mesa);

        Reserva reservaAtualizada = reservaRepository.save(reservaExistente);

        return DozerConverter.parseObject(reservaAtualizada, ReservaDTO.class);
    }

    public List <ReservaLowDTO> findAll(){
        List<Reserva> reservas = reservaRepository.findAll();
        return DozerConverter.parseListObjects(reservas, ReservaLowDTO.class);
    }
    public void delete(Long id) {
        reservaRepository.deleteById(id);
    }

    public ReservaDTO findById(Long id){
        var entity = reservaRepository.findById(id);
        if(entity.isEmpty()){
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "restaurante.service.reserva.notfound",
                    "o id da reserva informada não foi encontrado");
        }
        return DozerConverter.parseObject(entity.get(), ReservaDTO.class);
    }
}
