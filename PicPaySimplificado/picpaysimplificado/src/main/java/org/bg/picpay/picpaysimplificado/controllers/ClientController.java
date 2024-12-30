package org.bg.picpay.picpaysimplificado.controllers;

import jakarta.validation.Valid;
import org.bg.picpay.picpaysimplificado.dto.ClientDTO;
import org.bg.picpay.picpaysimplificado.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private ClientService clientService;



    @GetMapping("/list")
    public List<?> findAllUser(){
        return clientService.finAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable UUID id){
        return clientService.getUser(id);
    }


    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody @Valid ClientDTO userDto){
        return ClientService.addUser(userDto);
    }


}
