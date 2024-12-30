package org.bg.picpay.picpaysimplificado.repository;

import org.bg.picpay.picpaysimplificado.model.User.utils.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoginRepository extends JpaRepository<Login, UUID> {
}
