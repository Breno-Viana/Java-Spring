package org.bg.picpay.picpaysimplificado.controllers;

import org.bg.picpay.picpaysimplificado.dto.TransactionDto;
import org.bg.picpay.picpaysimplificado.model.Transations.Transactions;
import org.bg.picpay.picpaysimplificado.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transfer")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<Transactions> listAll(){
        return transactionService.listAll();
    }

    @PostMapping
    public ResponseEntity<?> Transfer(@RequestBody TransactionDto transactionDto) throws Exception{
        return transactionService.transfer(transactionDto);
    }

}
