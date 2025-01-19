package br.bg.project.bankaccount.BankAccount.infra.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class AuthResponsesErrors {
    protected final static ObjectMapper objectMapper = new ObjectMapper();


    @Bean
    public static AccessDeniedHandler customAccessDeniedHandler(){
        return ((request, response, accessDeniedException) -> {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.setContentType("application/json");
            Error error = new Error("Access Denied", HttpStatus.FORBIDDEN.value(), request.getRequestURI());
            response.getWriter().write(objectMapper.writeValueAsString(error));
        });
    }

}


record Error(String message,
             int status,
             String path) {}





