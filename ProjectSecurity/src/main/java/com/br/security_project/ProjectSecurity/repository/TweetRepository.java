package com.br.security_project.ProjectSecurity.repository;

import com.br.security_project.ProjectSecurity.entities.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet,Long> {
}
