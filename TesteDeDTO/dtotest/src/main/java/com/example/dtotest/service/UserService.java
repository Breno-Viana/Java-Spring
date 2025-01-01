package com.example.dtotest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dtotest.dto.UserDto;
import com.example.dtotest.models.UserJava;
import com.example.dtotest.repository.RepositoryTest;

@Service
public class UserService {
    
    @Autowired
    private RepositoryTest repositoryTest;
    
    public ResponseEntity<UserJava> add(UserDto userDto){
        UserJava user = new UserJava(userDto);
        repositoryTest.save(user);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }
}
