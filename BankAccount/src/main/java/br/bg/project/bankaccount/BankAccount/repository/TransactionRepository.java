package br.bg.project.bankaccount.BankAccount.repository;

import br.bg.project.bankaccount.BankAccount.models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions,Long> {
}
