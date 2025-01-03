package org.bg.picpay.picpaysimplificado.services;


import org.bg.picpay.picpaysimplificado.dto.requests.LoginRequest;
import org.bg.picpay.picpaysimplificado.dto.requests.LoginResponse;
import org.bg.picpay.picpaysimplificado.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class LoginService {


    @Autowired
    private LoginRepository repository;

    private Instant ExpiresAt(Long min){
        return LocalDateTime
                .now()
                .plusMinutes(min)
                .toInstant(ZoneOffset.of("-3"));
    }


    public ResponseEntity<LoginResponse> LOGIN(LoginRequest loginRequest) throws Exception{
        var client = repository.findByemail(loginRequest.login());

        if (client.isEmpty()||!client.get().isCorrectPassWord(loginRequest.password())){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return null;
    }





}
