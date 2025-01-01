package org.bg.picpay.picpaysimplificado.repository;

import org.bg.picpay.picpaysimplificado.model.Transations.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions, UUID> {

}
