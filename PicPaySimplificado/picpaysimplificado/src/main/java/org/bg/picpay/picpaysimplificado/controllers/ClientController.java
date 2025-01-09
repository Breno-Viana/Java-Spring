package org.bg.picpay.picpaysimplificado.controllers;

import jakarta.validation.Valid;
import org.bg.picpay.picpaysimplificado.dto.data.ClientDTO;
import org.bg.picpay.picpaysimplificado.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("c")
public class ClientController {

    @Autowired
    private ClientService clientService;


    @GetMapping("/list")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public List<?> findAllUser() {
        return clientService.finAllClients();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> getClient(@PathVariable UUID id) {
        return clientService.getClient(id);
    }


    @PostMapping("/register")
    //@PreAuthorize("hasAnyAuthority('SCOPE_ADMIN','SCOPE_BASIC')")
    public ResponseEntity<?> addUser(@RequestBody @Valid ClientDTO clientDto) throws Exception {
            return ClientService.addClient(clientDto);

    }

}
