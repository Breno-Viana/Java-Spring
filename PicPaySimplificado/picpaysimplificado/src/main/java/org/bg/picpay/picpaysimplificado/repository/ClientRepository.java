package org.bg.picpay.picpaysimplificado.repository;

import org.bg.picpay.picpaysimplificado.model.User.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {

}
