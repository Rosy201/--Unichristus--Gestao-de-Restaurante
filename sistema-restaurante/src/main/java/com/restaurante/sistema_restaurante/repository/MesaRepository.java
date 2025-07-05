package com.restaurante.sistema_restaurante.repository;

import com.restaurante.sistema_restaurante.data.model.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesaRepository extends JpaRepository<Mesa, Long> {
}
