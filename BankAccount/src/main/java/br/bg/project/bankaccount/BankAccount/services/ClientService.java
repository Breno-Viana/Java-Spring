package br.bg.project.bankaccount.BankAccount.services;

import br.bg.project.bankaccount.BankAccount.dto.ClientDto;
import br.bg.project.bankaccount.BankAccount.infra.errors.DuplicateExceptions;
import br.bg.project.bankaccount.BankAccount.models.Client;
import br.bg.project.bankaccount.BankAccount.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    public ResponseEntity<Client> REGISTER(ClientDto dto) throws Exception {
        var client = new Client(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientRepository.save(client));
    }

    public List<Client> LIST(){
        return clientRepository.findAll();
    }
}
