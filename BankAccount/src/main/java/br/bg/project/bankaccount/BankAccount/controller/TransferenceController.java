package br.bg.project.bankaccount.BankAccount.controller;

import br.bg.project.bankaccount.BankAccount.dto.TransactionDto;
import br.bg.project.bankaccount.BankAccount.models.Transactions;
import br.bg.project.bankaccount.BankAccount.services.TransactionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("t")
public class TransferenceController {

    @Autowired
    private TransactionService service;

    @PostMapping("/transfer")
    @Transactional
    public ResponseEntity<Transactions> TRANSFER(@RequestBody TransactionDto dto){
        return service.TRANSFER(dto);
    }


    @GetMapping("/l")
    public List<Transactions> LIST(){
        return service.LIST();
    }
}
