package br.bg.project.bankaccount.BankAccount.services;

import br.bg.project.bankaccount.BankAccount.dto.TransactionDto;
import br.bg.project.bankaccount.BankAccount.infra.errors.ClientNotFoundException;
import br.bg.project.bankaccount.BankAccount.infra.errors.CommencialAccountException;
import br.bg.project.bankaccount.BankAccount.infra.errors.EqualsClientException;
import br.bg.project.bankaccount.BankAccount.models.Client;
import br.bg.project.bankaccount.BankAccount.models.ClientType;
import br.bg.project.bankaccount.BankAccount.models.Transactions;
import br.bg.project.bankaccount.BankAccount.repository.ClientRepository;
import br.bg.project.bankaccount.BankAccount.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    public ResponseEntity<Transactions> TRANSFER(TransactionDto dto){
        ValidadeTransference(dto.sender(),dto.receiver());
        var sender = clientRepository.findById(dto.sender()).orElseThrow(ClientNotFoundException::new);
        var receiver = clientRepository.findById(dto.receiver()).orElseThrow(ClientNotFoundException::new);
        var transference = new Transactions(dto.value(),receiver,sender);
        return ResponseEntity.status(HttpStatus.OK).body(transactionRepository.save(transference));
    }


    private void ValidadeTransference(UUID sender,UUID receiver){
        var client = clientRepository.findById(sender).orElseThrow(ClientNotFoundException::new);
        if (client.getType() == ClientType.COMMERCIAL){
            throw new CommencialAccountException();
        }
        var client2 = clientRepository.findById(receiver).orElseThrow(ClientNotFoundException::new);
        if (client.getId()==client2.getId()){
            throw new EqualsClientException();
        }
    }
}
