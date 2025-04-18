package br.bg.project.bankaccount.BankAccount.services;

import br.bg.project.bankaccount.BankAccount.dto.response.LoginResponse;
import br.bg.project.bankaccount.BankAccount.models.Login;
import br.bg.project.bankaccount.BankAccount.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class LoginService implements UserDetailsService {

    private final LoginRepository repository;

    private final JwtService jwtService;

    public LoginService(LoginRepository repository, JwtService jwtService) {
        this.repository = repository;
        this.jwtService = jwtService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByLogin(username)
                .map(Login::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public ResponseEntity<LoginResponse> generateToken(Authentication authentication) {
        var token = jwtService.generateToken(authentication);
        var response = new LoginResponse(token, Instant.now().plusSeconds(3600));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }



}
