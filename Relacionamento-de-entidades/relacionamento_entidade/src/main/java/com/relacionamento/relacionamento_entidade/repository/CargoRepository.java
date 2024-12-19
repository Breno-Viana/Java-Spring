package com.relacionamento.relacionamento_entidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relacionamento.relacionamento_entidade.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo,Long> {
    
}
