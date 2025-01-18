package br.bg.project.bankaccount.BankAccount.repository;

import br.bg.project.bankaccount.BankAccount.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

    Optional<Client> findByDocument(String document);
}
