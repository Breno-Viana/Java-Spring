package org.bg.picpay.picpaysimplificado.repository;

import org.bg.picpay.picpaysimplificado.model.User.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

}
