package br.com.training.trainingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.training.trainingapp.models.Registers;

import java.util.Optional;

@Repository
public interface RepositoryForService extends JpaRepository<Registers,Long> {
    Optional<Registers> findByemail(String email);
}
