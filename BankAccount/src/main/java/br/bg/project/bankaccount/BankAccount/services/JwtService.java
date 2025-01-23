package br.bg.project.bankaccount.BankAccount.services;


import br.bg.project.bankaccount.BankAccount.infra.exceptions.errors.ClientNotFoundException;
import br.bg.project.bankaccount.BankAccount.models.Login;
import br.bg.project.bankaccount.BankAccount.models.enums.Roles;
import br.bg.project.bankaccount.BankAccount.repository.ClientRepository;
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


    @Autowired
    private ClientRepository clientRepository;


    public String generateToken(Authentication authentication) {
        Instant now = Instant.now();
        Instant exp = now.plusSeconds(3600);

        var roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();

        var login = (Login) authentication.getPrincipal();
        if (login.getRole() == Roles.ADMIN) return LoginAdmin(login);

        var ClientDetails = clientRepository.findByLogin(login).orElseThrow(() -> new ClientNotFoundException("Client not found"));

        var claims = JwtClaimsSet.builder()
                .issuer("project_bank_account")
                .issuedAt(now)
                .expiresAt(exp)
                .subject(ClientDetails.getId().toString())
                .claim("scope", roles)
                .build();
        return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    private String LoginAdmin(Login login){
        var roles = login.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();


        var claims = JwtClaimsSet.builder()
                .expiresAt(Instant.now().plusSeconds(3600))
                .issuedAt(Instant.now())
                .subject(login.getUsername())
                .issuer("project_bank_account")
                .claim("roles", roles)
                .build();

        return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}
