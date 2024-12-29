package org.bg.picpay.picpaysimplificado.services;

import org.bg.picpay.picpaysimplificado.dto.ClientDTO;
import org.bg.picpay.picpaysimplificado.exceptions.error.UserNotFoundException;
import org.bg.picpay.picpaysimplificado.model.User.Client;
import org.bg.picpay.picpaysimplificado.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Client> finAllUsers(){
        return userRepository.findAll();
    }


    public ResponseEntity<?> addUser(ClientDTO userDto){
        return userDto==null? new ResponseEntity<>(HttpStatus.BAD_REQUEST):new ResponseEntity<>(userRepository.save(new Client(userDto)),HttpStatus.CREATED);
    }


    public ResponseEntity<Client> getUser(UUID i){
        var user = userRepository.findById(i);
       if (user.isEmpty()){
           throw new UserNotFoundException(i);
       }
       return new ResponseEntity<>(user.get(),HttpStatus.FOUND);
    }
}
