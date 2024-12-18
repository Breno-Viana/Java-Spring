package com.relacionamento.relacionamento_entidade.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relacionamento.relacionamento_entidade.dto.CargoDto;
import com.relacionamento.relacionamento_entidade.model.Cargo;
import com.relacionamento.relacionamento_entidade.repository.CargoRepository;

@RestController
@RequestMapping("/cargo")
public class CargoController {



    private CargoRepository repository;

    public CargoController(CargoRepository repository){
        this.repository = repository;
    }
    
    @GetMapping("/listar")
    public List<Cargo> listar(){
        return repository.findAll();
    }

    @PostMapping("/adicionar")
    public ResponseEntity<Cargo> adicionar(@RequestBody CargoDto dto){
        Cargo cargo = new Cargo(dto);
        repository.save(cargo);

        return new ResponseEntity<Cargo>(cargo,HttpStatus.CREATED);
    }
}
