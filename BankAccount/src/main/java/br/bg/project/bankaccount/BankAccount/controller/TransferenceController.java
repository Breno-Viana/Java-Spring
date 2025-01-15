package br.bg.project.bankaccount.BankAccount.controller;

import br.bg.project.bankaccount.BankAccount.dto.TransactionDto;
import br.bg.project.bankaccount.BankAccount.models.Transactions;
import br.bg.project.bankaccount.BankAccount.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("t")
public class TransferenceController {

    @Autowired
    private TransactionService service;

    @PostMapping("/trasfer")
    public ResponseEntity<Transactions> TRANSFER(TransactionDto dto){
        return service.TRANSFER(dto);
    }
}
