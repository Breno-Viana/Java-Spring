package com.br.security_project.ProjectSecurity.controller;


import com.br.security_project.ProjectSecurity.dto.UserDTO;
import com.br.security_project.ProjectSecurity.entities.Role;
import com.br.security_project.ProjectSecurity.entities.User;
import com.br.security_project.ProjectSecurity.repository.RoleRepository;
import com.br.security_project.ProjectSecurity.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder encoder;

    public UserController(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<Void> addUser(@RequestBody UserDTO dto){
        var role = roleRepository.findByname(Role.Values.BASIC.name()).orElseThrow();

        userRepository.findByuserName(dto.username()).ifPresent(
                ex -> {
                    throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
                }
        );

        var user = new User();
        user.setUserName(dto.username());
        user.setPassWord(encoder.encode(dto.password()));
        user.setRoles(Set.of(role));

        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<User>> listAll(){
        return ResponseEntity.ok().body(userRepository.findAll());
    }

}
