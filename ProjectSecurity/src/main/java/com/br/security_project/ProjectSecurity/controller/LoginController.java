package com.br.security_project.ProjectSecurity.controller;

import com.br.security_project.ProjectSecurity.dto.LoginRequest;
import com.br.security_project.ProjectSecurity.dto.LoginResponse;
import com.br.security_project.ProjectSecurity.entities.Role;
import com.br.security_project.ProjectSecurity.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/token")
public class LoginController {
    private final JwtEncoder jwtEncoder;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public LoginController(JwtEncoder j, UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.jwtEncoder=j;
        this.userRepository=userRepository;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
    }



    @PostMapping("/login")
    public ResponseEntity<LoginResponse> log_in(@RequestBody LoginRequest loginRequest){
        var user = userRepository.findByuserName(loginRequest.username());
        if(user.isEmpty() || !user.get().isLoginCorrect(loginRequest,bCryptPasswordEncoder)){
            throw new BadCredentialsException("Usuario invalido");
        }
        var scopes = user.get()
                .getRoles()
                .stream()
                .map(Role::getName)
                .collect(Collectors.joining( " "));


        var expire = expiresAt();


        var claim = JwtClaimsSet.builder()
                .issuer("security")
                .subject(user.get().getId().toString())
                .claim("role:",scopes)
                .expiresAt(expire)
                .issuedAt(Instant.now())
                .build();

        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claim)).getTokenValue();

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new LoginResponse(jwtValue,expire.toEpochMilli()));
    }



    private Instant expiresAt(){
        return LocalDateTime
                .now()
                .plusHours(1L)
                .toInstant(ZoneOffset.of("-3"));
    }
}
