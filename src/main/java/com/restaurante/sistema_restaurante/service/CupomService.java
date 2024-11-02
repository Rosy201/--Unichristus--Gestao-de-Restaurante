package com.restaurante.sistema_restaurante.service;

import com.restaurante.sistema_restaurante.data.dto.CupomDTO;
import com.restaurante.sistema_restaurante.data.model.Cupom;
import com.restaurante.sistema_restaurante.data.model.Reserva;
import com.restaurante.sistema_restaurante.email.EmailService;
import com.restaurante.sistema_restaurante.repository.CupomRepository;
import com.restaurante.sistema_restaurante.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class CupomService {

    private final CupomRepository cupomRepository;
    private final ReservaRepository reservaRepository;
    private final EmailService emailService;
    private final TaskScheduler taskScheduler;

    @Autowired
    public CupomService(CupomRepository cupomRepository, EmailService emailService,
                        ReservaRepository reservaRepository, @Qualifier("cupomTaskScheduler") TaskScheduler taskScheduler) {
        this.cupomRepository = cupomRepository;
        this.emailService = emailService;
        this.reservaRepository = reservaRepository;
        this.taskScheduler = taskScheduler;
    }

    public CupomDTO createCupom(Long reservaId) {
        Cupom cupom = new Cupom();
        cupom.setCodigo("DESCONTO10");
        cupom.setDesconto(10.0);

        Reserva reserva = reservaRepository.findById(reservaId)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));

        cupom = cupomRepository.save(cupom);

        String emailCliente = reserva.getCliente().getEmail();
        Cupom finalCupom = cupom;
        taskScheduler.schedule(() -> emailService.sendCupomEmail(emailCliente,
                        finalCupom.getCodigo(), finalCupom.getDesconto()),
                Instant.now().plus(1, ChronoUnit.MINUTES));
        
        return null;
    }

}
