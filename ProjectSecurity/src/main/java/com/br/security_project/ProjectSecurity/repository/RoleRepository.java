package com.br.security_project.ProjectSecurity.repository;

import com.br.security_project.ProjectSecurity.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
