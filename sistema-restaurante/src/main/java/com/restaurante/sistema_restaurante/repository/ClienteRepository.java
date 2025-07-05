package com.restaurante.sistema_restaurante.repository;

import com.restaurante.sistema_restaurante.data.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
