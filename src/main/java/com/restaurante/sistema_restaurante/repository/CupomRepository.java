package com.restaurante.sistema_restaurante.repository;

import com.restaurante.sistema_restaurante.data.model.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CupomRepository extends JpaRepository<Cupom, Long> {
}
