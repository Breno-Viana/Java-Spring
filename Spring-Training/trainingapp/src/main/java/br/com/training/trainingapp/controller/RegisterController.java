package br.com.training.trainingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import br.com.training.trainingapp.services.register_service.RegisterService;
import br.com.training.trainingapp.models.Registers;
import jakarta.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/")
public class RegisterController {

    @Autowired
    RegisterService registerService;


    @GetMapping("pegar/listar")
    public List<Registers> ListReg() {
        return registerService.ListRegisters();
    }
 

    @PostMapping("registrar")
    public ResponseEntity<Registers> AddRegister(@RequestBody @Valid Registers register) {
         return registerService.newCreation(register);
    }

    @PutMapping("edit/admin/{id}")
    public ResponseEntity<Registers> Edit(@PathVariable Long id, @RequestBody @Valid Registers register) {
        return registerService.newEdit(id, register);
    }

    @DeleteMapping("delete/admin/id/{id}")
    public ResponseEntity<Registers> Delet(@PathVariable Long id){
        return registerService.newDelet(id);
    }

    @GetMapping("pegar/{id}")
    public ResponseEntity<Registers> newGRegisters(@PathVariable Long id){
        return registerService.getBYId(id);
    }

    @DeleteMapping("delete/admin/{name}")
    public ResponseEntity<Registers> d(@PathVariable String name){
        return registerService.delAllByName(name);
    }

    @PutMapping("edit/admin/situacao/{id}/{situation}")
    public ResponseEntity<Registers> uptSituation(@PathVariable Long id, @PathVariable char situation){
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

    @PutMapping("desativar")
    public ResponseEntity<Registers> dEntity(){
        return registerService.desativeAll();
    }
}
