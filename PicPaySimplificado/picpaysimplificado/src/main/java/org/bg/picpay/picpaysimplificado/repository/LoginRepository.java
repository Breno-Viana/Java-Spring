package org.bg.picpay.picpaysimplificado.repository;

import org.bg.picpay.picpaysimplificado.model.User.utils.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface LoginRepository extends JpaRepository<Credentials, UUID> {
    Optional<Credentials> findByemail(String Email);

}
