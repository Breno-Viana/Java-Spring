package br.com.training.trainingapp.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import br.com.training.trainingapp.models.Registers;
import br.com.training.trainingapp.services.register_service.RegisterService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/registro")
public class RegisterController {

    @Autowired
    RegisterService registerService;


    @GetMapping("/listar")
    public List<Registers> ListReg(){
       return registerService.ListRegisters();
    }

    @PostMapping("/registrar")
    public void AddRegister(@RequestBody @Valid Registers register) {
        registerService.newCreation(register);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity Edit(@PathVariable Long id, @RequestBody @Valid Registers register){
        return registerService.newEdit(id,register);
    }
}
