package com.br.security_project.ProjectSecurity.dto;

public record LoginResponse(String Token, Long expiresIn) {
}
