package br.bg.project.bankaccount.BankAccount.repository;

import br.bg.project.bankaccount.BankAccount.models.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LoginRepository extends JpaRepository<Login, UUID> {

    Optional<Login> findByLogin(String login);
}
