package org.bg.picpay.picpaysimplificado.controllers;

import jakarta.validation.Valid;
import org.bg.picpay.picpaysimplificado.dto.UserDto;
import org.bg.picpay.picpaysimplificado.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping("/list")
    public List<?> findAllUser(){
        return userService.finAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable UUID id){
        return userService.getUser(id);
    }


    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody @Valid UserDto userDto){
        return userService.addUser(userDto);
    }


}
