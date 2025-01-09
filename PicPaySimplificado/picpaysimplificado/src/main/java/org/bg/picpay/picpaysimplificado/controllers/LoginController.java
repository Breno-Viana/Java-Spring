package org.bg.picpay.picpaysimplificado.controllers;

import org.bg.picpay.picpaysimplificado.dto.requests.LoginRequest;
import org.bg.picpay.picpaysimplificado.dto.requests.LoginResponse;
import org.bg.picpay.picpaysimplificado.repository.LoginRepository;
import org.bg.picpay.picpaysimplificado.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {


    @Autowired
    private LoginService service;

    @Autowired
    private LoginRepository loginRepository;


    @PostMapping
    public ResponseEntity<LoginResponse>LOGIN(@RequestBody LoginRequest loginRequest) throws Exception {

        return service.LOGIN(loginRequest);
    }
}
