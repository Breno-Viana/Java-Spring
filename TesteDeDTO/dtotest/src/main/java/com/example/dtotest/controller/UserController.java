package com.example.dtotest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dtotest.dto.UserDto;
import com.example.dtotest.models.UserJava;
import com.example.dtotest.service.UserService;

@RestController
@RequestMapping
public class UserController {

    
    @Autowired
    private UserService service;


    @PostMapping("postar")
    public ResponseEntity<UserJava> add(@RequestBody UserDto userDto){
        return service.add(userDto);
    }
}
