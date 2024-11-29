package br.com.training.trainingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.training.trainingapp.models.Registers;

public interface RepositoryForService extends JpaRepository<Registers,Long> {
    
}
