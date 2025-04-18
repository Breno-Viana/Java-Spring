package br.bg.project.bankaccount.BankAccount.controller;

import br.bg.project.bankaccount.BankAccount.dto.ClientDto;
import br.bg.project.bankaccount.BankAccount.models.Client;
import br.bg.project.bankaccount.BankAccount.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/c")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @PostMapping("/sign-up")
    @Transactional
    public ResponseEntity<Client> addClient(@RequestBody @Valid ClientDto dto) throws Exception {
        return clientService.REGISTER(dto);
    }

    @GetMapping("/admin/all")
    public List<Client> LIST(){
        return clientService.LIST();
    }
}
