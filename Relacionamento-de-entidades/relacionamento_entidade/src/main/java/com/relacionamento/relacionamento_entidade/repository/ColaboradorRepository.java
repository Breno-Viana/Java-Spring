package com.relacionamento.relacionamento_entidade.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relacionamento.relacionamento_entidade.model.Colaborador;

public interface ColaboradorRepository extends JpaRepository<Colaborador,UUID> {
    
}
