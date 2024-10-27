package com.restaurante.sistema_restaurante.repository;

import com.restaurante.sistema_restaurante.data.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
