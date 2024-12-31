package org.bg.picpay.picpaysimplificado.services;


import org.bg.picpay.picpaysimplificado.dto.TransactionDTO;
import org.bg.picpay.picpaysimplificado.infra.exceptions.error.CommercialAccountException;
import org.bg.picpay.picpaysimplificado.infra.exceptions.error.EqualsClientException;
import org.bg.picpay.picpaysimplificado.infra.exceptions.error.NoBalanceException;
import org.bg.picpay.picpaysimplificado.infra.exceptions.error.ClientNotFoundException;
import org.bg.picpay.picpaysimplificado.model.Transations.Transactions;
import org.bg.picpay.picpaysimplificado.model.User.utils.AccountType;
import org.bg.picpay.picpaysimplificado.model.User.Client;
import org.bg.picpay.picpaysimplificado.repository.TransactionRepository;
import org.bg.picpay.picpaysimplificado.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final ClientRepository userRepository;

    public TransactionService(ClientRepository userRepository, TransactionRepository transactionRepository){
        this.userRepository = userRepository;
        this.transactionRepository=transactionRepository;
    }


    private void ValidateTransaction(UUID senderId,UUID receiverID, BigDecimal amount){
        Client sender = userRepository.findById(senderId).orElseThrow(ClientNotFoundException::new);
        Client receiver = userRepository.findById(receiverID).orElseThrow(ClientNotFoundException::new);
        if (sender.getAccount().equals(AccountType.COMMERCIAL)){
            throw new CommercialAccountException();
        }

        if (sender.getBalance().compareTo(amount)<0){
            throw new NoBalanceException(amount.toString());
        }

        if (sender == receiver){
            throw new EqualsClientException();
        }
    }


    @Transactional
    public ResponseEntity<?> transfer(TransactionDTO dto) {
        Client sender = userRepository.findById(dto.senderID()).orElseThrow(ClientNotFoundException::new);
        Client receiver = userRepository.findById(dto.receiverID()).orElseThrow(ClientNotFoundException::new);

        ValidateTransaction(dto.senderID(),dto.receiverID(),dto.amount());

        receiver.setBalance(receiver.getBalance().add(dto.amount()));
        sender.setBalance(sender.getBalance().subtract(dto.amount()));

        Transactions transactions = new Transactions(sender,receiver,dto.amount());
        transactionRepository.save(transactions);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    public List<Transactions> listAll(){
        return transactionRepository.findAll();
    }
}
