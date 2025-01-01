package com.example.dtotest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dtotest.models.UserJava;

public interface RepositoryTest extends JpaRepository<UserJava,Long> {
    
}
