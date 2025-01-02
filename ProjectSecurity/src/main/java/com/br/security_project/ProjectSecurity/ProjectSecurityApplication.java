package com.br.security_project.ProjectSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity
public class ProjectSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectSecurityApplication.class, args);
	}

}
