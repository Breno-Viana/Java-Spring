package br.bg.project.bankaccount.BankAccount.services;

import br.bg.project.bankaccount.BankAccount.dto.ClientDto;
import br.bg.project.bankaccount.BankAccount.infra.errors.DuplicateExceptions;
import br.bg.project.bankaccount.BankAccount.models.Client;
import br.bg.project.bankaccount.BankAccount.repository.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    public ResponseEntity<Client> register(@Valid ClientDto dto){
        var client = new Client(dto);
        clientRepository.findById(client.getId())
                .ifPresent(DuplicateExceptions::new);

        return ResponseEntity.status(HttpStatus.CREATED).body(clientRepository.save(client));

    }
}
