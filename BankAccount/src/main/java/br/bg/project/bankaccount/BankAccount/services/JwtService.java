package br.bg.project.bankaccount.BankAccount.services;


import br.bg.project.bankaccount.BankAccount.models.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
public class JwtService {

    @Autowired
    private JwtEncoder encoder;


    public String generateToken(Authentication authentication) {
        Instant now = Instant.now();
        Instant exp = now.plusSeconds(3600);

        String scopes = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));


        var claims = JwtClaimsSet.builder()
                .issuer("project_bank_account")
                .issuedAt(now)
                .expiresAt(exp)
                .subject(authentication.getName())
                .claim("scope", scopes)
                .build();
        return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}
