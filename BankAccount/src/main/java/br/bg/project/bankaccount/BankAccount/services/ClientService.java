package br.bg.project.bankaccount.BankAccount.services;

import br.bg.project.bankaccount.BankAccount.dto.ClientDto;
import br.bg.project.bankaccount.BankAccount.infra.exceptions.errors.ClientAlreadyExistsException;
import br.bg.project.bankaccount.BankAccount.models.Client;
import br.bg.project.bankaccount.BankAccount.models.Login;
import br.bg.project.bankaccount.BankAccount.models.enums.Roles;
import br.bg.project.bankaccount.BankAccount.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    @Autowired
    private PasswordEncoder encoder;


    public ResponseEntity<Client> REGISTER(ClientDto dto) throws Exception {
        clientRepository.findByDocument(dto.document())
                .ifPresent(client -> {throw new ClientAlreadyExistsException();});
        var login = new Login(dto.email(), encoder.encode(dto.password()), Roles.BASIC);
        var client = new Client(dto,login);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientRepository.save(client));
    }

    public List<Client> LIST(){
        return clientRepository.findAll();
    }
}
