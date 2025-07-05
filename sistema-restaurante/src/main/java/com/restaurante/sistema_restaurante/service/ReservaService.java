package com.restaurante.sistema_restaurante.service;

import com.restaurante.sistema_restaurante.data.dto.ReservaDTO;
import com.restaurante.sistema_restaurante.data.dto.ReservaLowDTO;
import com.restaurante.sistema_restaurante.data.model.Cliente;
import com.restaurante.sistema_restaurante.data.model.Mesa;
import com.restaurante.sistema_restaurante.data.model.Reserva;
import com.restaurante.sistema_restaurante.dozer.DozerConverter;
<<<<<<< HEAD:src/main/java/com/restaurante/sistema_restaurante/service/ReservaService.java
import com.restaurante.sistema_restaurante.email.EmailService;
=======
//import com.restaurante.sistema_restaurante.email.EmailService;
>>>>>>> 7d34b07 (Adiciona frontend e reorganiza estrutura do projeto):sistema-restaurante/src/main/java/com/restaurante/sistema_restaurante/service/ReservaService.java
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
<<<<<<< HEAD:src/main/java/com/restaurante/sistema_restaurante/service/ReservaService.java
    private final EmailService emailService;
=======
//    private final EmailService emailService;
>>>>>>> 7d34b07 (Adiciona frontend e reorganiza estrutura do projeto):sistema-restaurante/src/main/java/com/restaurante/sistema_restaurante/service/ReservaService.java

    @Autowired
    public ReservaService(ReservaRepository reservarepository,
                          ClienteRepository clienteRepository,
<<<<<<< HEAD:src/main/java/com/restaurante/sistema_restaurante/service/ReservaService.java
                          MesaRepository mesaRepository,
                          EmailService emailService) {
        this.reservaRepository = reservarepository;
        this.clienteRepository = clienteRepository;
        this.mesaRepository = mesaRepository;
        this.emailService = emailService;
    }
=======
                          MesaRepository mesaRepository) {
        this.reservaRepository = reservarepository;
        this.clienteRepository = clienteRepository;
        this.mesaRepository = mesaRepository;}
>>>>>>> 7d34b07 (Adiciona frontend e reorganiza estrutura do projeto):sistema-restaurante/src/main/java/com/restaurante/sistema_restaurante/service/ReservaService.java
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

        //emailService.sendCupomEmail(cliente.getEmail(), "DESCONTO10", 10.0);
        
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
