package br.bg.project.bankaccount.BankAccount.services;

import br.bg.project.bankaccount.BankAccount.dto.TransactionDto;
import br.bg.project.bankaccount.BankAccount.infra.exceptions.errors.ClientNotFoundException;
import br.bg.project.bankaccount.BankAccount.infra.exceptions.errors.CommencialAccountException;
import br.bg.project.bankaccount.BankAccount.infra.exceptions.errors.EqualsClientException;
import br.bg.project.bankaccount.BankAccount.infra.exceptions.errors.NoBalanceException;
import br.bg.project.bankaccount.BankAccount.models.enums.ClientType;
import br.bg.project.bankaccount.BankAccount.models.Transactions;
import br.bg.project.bankaccount.BankAccount.repository.ClientRepository;
import br.bg.project.bankaccount.BankAccount.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    public ResponseEntity<Transactions> TRANSFER(TransactionDto dto){
        ValidadeTransference(dto);

        var sender = clientRepository.findById(dto.sender()).orElseThrow(ClientNotFoundException::new);

        var receiver = clientRepository.findById(dto.receiver()).orElseThrow(ClientNotFoundException::new);

        receiver.setAmount(receiver.getAmount().add(dto.value()));
        sender.setAmount(sender.getAmount().subtract(dto.value()));

        var transference = new Transactions(dto.value(),receiver,sender);
        return ResponseEntity.status(HttpStatus.OK).body(transactionRepository.save(transference));
    }


    private void ValidadeTransference(TransactionDto dto){
        var client = clientRepository.findById(dto.sender()).orElseThrow(ClientNotFoundException::new);
        if (client.getType() == ClientType.COMMERCIAL){
            throw new CommencialAccountException();
        }
        var client2 = clientRepository.findById(dto.receiver()).orElseThrow(ClientNotFoundException::new);
        if (client.getId()==client2.getId()){
            throw new EqualsClientException();
        }

        if (client.getAmount().compareTo(dto.value())<0){
            throw new NoBalanceException();
        }
    }

    public List<Transactions> LIST() {
        return transactionRepository.findAll();
    }
}
