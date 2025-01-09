package org.bg.picpay.picpaysimplificado.services;

import org.bg.picpay.picpaysimplificado.dto.requests.LoginRequest;
import org.bg.picpay.picpaysimplificado.dto.requests.LoginResponse;
import org.bg.picpay.picpaysimplificado.infra.exceptions.error.ClientNotFoundException;
import org.bg.picpay.picpaysimplificado.infra.exceptions.error.IllegalCredentialsException;
import org.bg.picpay.picpaysimplificado.model.User.utils.Roles;
import org.bg.picpay.picpaysimplificado.model.User.utils.Credentials;
import org.bg.picpay.picpaysimplificado.repository.ClientRepository;
import org.bg.picpay.picpaysimplificado.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class LoginService{


    @Autowired
    private LoginRepository repository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private JwtEncoder jwtEncoder;

    @Autowired
    private ClientRepository clientRepository;



    private Instant ExpiresAt(Long min){
        ZoneOffset brasil = ZoneOffset.of("-03:00");
        return LocalDateTime
                .now()
                .plusMinutes(min)
                .toInstant(brasil);
    }


    public ResponseEntity<LoginResponse> LOGIN(LoginRequest loginRequest){
        var checkUp = repository.findByDocument(loginRequest.login());


        if (checkUp.isEmpty()||!checkUp.get().isCorrectPassWord(loginRequest.password(), encoder)) throw new IllegalCredentialsException();
        if (checkUp.get().getRole() == Roles.ADMIN){
            return loginAsAdmin(checkUp.get());
        }

        var client = clientRepository.findByCredentials(checkUp.get()).orElseThrow(
                ClientNotFoundException::new
        );



        var claim = JwtClaimsSet.builder()
                .issuer("project_simple_bank_account")
                .subject(client.getId().toString())
                .claim("email",checkUp.get().getEmail())
                .claim("scope",client.getCredentials().getRole())
                .expiresAt(ExpiresAt(10L))
                .issuedAt(ExpiresAt(0L))
                .build();



        var token = jwtEncoder.encode(JwtEncoderParameters.from(claim)).getTokenValue();
        var response = new LoginResponse(token,ExpiresAt(10L));



        return ResponseEntity.status(HttpStatus.OK).body(response);
    }



    private ResponseEntity<LoginResponse>loginAsAdmin(Credentials credentials){
        var claim = JwtClaimsSet.builder()
                .issuer("project_simple_bank_account")
                .issuedAt(Instant.now())
                .subject(credentials.getEmail())
                .claim("scope",credentials.getRole())
                .expiresAt(ExpiresAt(10L))
                .build();
        var token = jwtEncoder.encode(JwtEncoderParameters.from(claim)).getTokenValue();
        return ResponseEntity.status(HttpStatus.OK).body(new LoginResponse(token,ExpiresAt(10L)));
    }




}
