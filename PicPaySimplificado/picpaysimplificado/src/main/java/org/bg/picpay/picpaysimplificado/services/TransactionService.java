package org.bg.picpay.picpaysimplificado.services;


import jakarta.transaction.Transactional;
import org.bg.picpay.picpaysimplificado.dto.TransactionDto;
import org.bg.picpay.picpaysimplificado.model.Transations.Transactions;
import org.bg.picpay.picpaysimplificado.model.User.AccountType;
import org.bg.picpay.picpaysimplificado.model.User.User;
import org.bg.picpay.picpaysimplificado.repository.TransactionRepository;
import org.bg.picpay.picpaysimplificado.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private static UserRepository userRepository;

    public TransactionService(UserRepository userRepository, TransactionRepository transactionRepository){
        TransactionService.userRepository = userRepository;
        this.transactionRepository=transactionRepository;
    }


    private static void ValidateTransaction(UUID senderId, BigDecimal amount) throws Exception{
        User sender = userRepository.findById(senderId).orElseThrow(RuntimeException::new);
        if (sender.getAccount().equals(AccountType.COMMERCIAL)){
            throw new RuntimeException("conta do tipo comercial");
        }

        if (sender.getBalance().compareTo(amount)<0){
            throw new RuntimeException("sem saldo bancario");
        }
    }


    @Transactional
    public ResponseEntity<?> transfer(TransactionDto dto) throws Exception {
        User sender = userRepository.findById(dto.senderID()).orElseThrow(RuntimeException::new);
        User receiver = userRepository.findById(dto.receiverID()).orElseThrow(RuntimeException::new);

        ValidateTransaction(dto.senderID(),dto.amount());

        receiver.setBalance(receiver.getBalance().add(dto.amount()));
        sender.setBalance(sender.getBalance().subtract(dto.amount()));

        Transactions transactions = new Transactions(sender,receiver,dto.amount());
        userRepository.saveAll(Arrays.asList(sender,receiver));
        transactionRepository.save(transactions);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    public List<Transactions> listAll(){
        return transactionRepository.findAll();
    }
}
