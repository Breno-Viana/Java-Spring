package org.bg.picpay.picpaysimplificado.controllers;

import org.bg.picpay.picpaysimplificado.dto.data.TransactionDTO;
import org.bg.picpay.picpaysimplificado.model.Transations.Transactions;
import org.bg.picpay.picpaysimplificado.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transfer")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/l")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public List<Transactions> listAll(){
        return transactionService.listAll();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_BASIC')")
    public ResponseEntity<?> Transfer(@RequestBody TransactionDTO transactionDto) throws Exception{
        return transactionService.transfer(transactionDto);
    }

}
