package com.relacionamento.relacionamento_entidade.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relacionamento.relacionamento_entidade.dto.ColaboradorDto;
import com.relacionamento.relacionamento_entidade.model.Cargo;
import com.relacionamento.relacionamento_entidade.model.Colaborador;
import com.relacionamento.relacionamento_entidade.repository.CargoRepository;
import com.relacionamento.relacionamento_entidade.repository.ColaboradorRepository;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {
    
   protected final ColaboradorRepository repository;
   protected final CargoRepository repository2;


    public ColaboradorController(ColaboradorRepository repository, CargoRepository cargoRepository){
        this.repository= repository;
        this.repository2 = cargoRepository;
    }

    @GetMapping("/listar")
    public List<Colaborador> listar(){
        return repository.findAll();
    }

    @PostMapping("/adicionar")
    public ResponseEntity<Colaborador> adicEntity(@RequestBody ColaboradorDto dto){
        Optional<Cargo> carOpt = repository2.findById(dto.cargo());
        if (carOpt.isEmpty()) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
        Colaborador colaborador = new Colaborador(dto,carOpt.get());
        repository.save(colaborador);
        return new ResponseEntity<Colaborador>(colaborador,HttpStatus.CREATED);
    }

    @GetMapping("/pegar/{id}")
    public ResponseEntity<Colaborador> getById(@PathVariable UUID id){
        Optional<Colaborador> opt = repository.findById(id);
       return opt.map(colaborador -> new ResponseEntity<>(colaborador, HttpStatus.ACCEPTED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
