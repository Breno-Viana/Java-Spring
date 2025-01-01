package br.com.training.trainingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.training.trainingapp.models.Registers;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RepositoryForService extends JpaRepository<Registers, String> {
    Optional<Registers> findByemail(String email);
}
