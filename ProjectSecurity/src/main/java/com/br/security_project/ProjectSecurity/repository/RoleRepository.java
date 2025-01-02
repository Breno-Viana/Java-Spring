package com.br.security_project.ProjectSecurity.repository;

import com.br.security_project.ProjectSecurity.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findByname(String name);
}
