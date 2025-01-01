package br.com.training.trainingapp.controller;

import br.com.training.trainingapp.dto.RegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import br.com.training.trainingapp.services.RegisterService;
import br.com.training.trainingapp.models.Registers;
import jakarta.validation.Valid;
import java.util.*;
import static br.com.training.trainingapp.services.RegisterService.ListRegisters;

@RestController
@RequestMapping("/")
public class RegisterController {

    @Autowired
    RegisterService registerService;


    @GetMapping("pegar/listar")
    public List<Registers> ListReg() {
        return ListRegisters();
    }

 

    @PostMapping("registrar")
    public ResponseEntity<Registers> AddRegister(@RequestBody @Valid RegisterDto register) {
         return registerService.newCreation(register);
    }

    @PutMapping("edit/admin/{id}")
    public ResponseEntity<Registers> Edit(@PathVariable String id, @RequestBody @Valid RegisterDto register) {
        return registerService.newEdit(id, register);
    }

    @DeleteMapping("delete/admin/id/{id}")
    public ResponseEntity<Registers> DeleteRegister(@PathVariable String id){
        return registerService.newDelet(id);
    }

    @GetMapping("pegar/id/{id}")
    public ResponseEntity<Registers> newGRegisters(@PathVariable String id){
        return registerService.getBYId(id);
    }

    @GetMapping("pegar/email/{email}")
    public ResponseEntity<Registers> email(@PathVariable String email){
        return registerService.findEmail(email);
    }

    @DeleteMapping("delete/admin/{name}")
    public ResponseEntity<Registers> deleteByName(@PathVariable String name){
        return registerService.delAllByName(name);
    }

    @PutMapping("edit/admin/situacao/{id}/{situation}")
    public ResponseEntity<Registers> uptSituation(@PathVariable String id, @PathVariable char situation){
        return registerService.UpdateSituation(id, situation);
    }

    @GetMapping("registers/cont")
    public ResponseEntity<Registers> Cont(){
        return registerService.getCount();
    }

    @GetMapping("registers/cont/st/{c}")
    public ResponseEntity<Registers> Cont(@PathVariable char c){
        return registerService.getCount(c);
    }

    @PutMapping("admin/desativar")
    public ResponseEntity<Registers> dEntity(){
        return registerService.desativeAll();
    }

    @PutMapping("admin/ativar")
    public ResponseEntity<Registers> aEntity(){
        return registerService.activeAll();
    }

    
}
