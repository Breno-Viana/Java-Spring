package br.bg.project.bankaccount.BankAccount.controller;

import br.bg.project.bankaccount.BankAccount.dto.response.LoginResponse;
import br.bg.project.bankaccount.BankAccount.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class LoginController {

    private final LoginService service;

    public LoginController(LoginService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<LoginResponse> login(Authentication authentication) {
        return service.generateToken(authentication);
    }
}
