package org.bg.picpay.picpaysimplificado.services;

import org.bg.picpay.picpaysimplificado.dto.UserDto;
import org.bg.picpay.picpaysimplificado.model.User.User;
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

    public List<User> finAllUsers(){
        return userRepository.findAll();
    }


    public ResponseEntity<?> addUser(UserDto userDto){
        return userDto==null? new ResponseEntity<>(HttpStatus.BAD_REQUEST):new ResponseEntity<>(userRepository.save(new User(userDto)),HttpStatus.CREATED);
    }


    public ResponseEntity<?> getUser(UUID i){
        var user = userRepository.findById(i);

        return user.isEmpty()? new ResponseEntity<>(HttpStatus.NOT_FOUND):new ResponseEntity<>(user.get(),HttpStatus.ACCEPTED);
    }
}
