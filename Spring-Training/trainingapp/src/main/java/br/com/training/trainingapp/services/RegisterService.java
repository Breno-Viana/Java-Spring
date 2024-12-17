package br.com.training.trainingapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.training.trainingapp.dto.RegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.training.trainingapp.models.Registers;
import br.com.training.trainingapp.repository.RepositoryForService;
import br.com.training.trainingapp.utils.Check;
import br.com.training.trainingapp.utils.CustomResponse;
import br.com.training.trainingapp.utils.UserSituation;

@Service
public class RegisterService {

    @Autowired
    private RepositoryForService repository;

    @Autowired
    private Check check;

    public List<Registers> ListRegisters() {
        return repository.findAll();
    }

    public ResponseEntity<Registers> newCreation(RegisterDto registerDto) {
        Registers register = new Registers(registerDto);

        if (check.CheckDuplicate(register)) {//checa de maneira simples se um o email e o identificador esta duplicado de alguma forma no banco de dados, se qualquer um dos dois existir, o usuario nao podera ser cadastado;
            return new CustomResponse().getMessage("o usuario " + registerDto.nome() + " ja existe",
                    HttpStatus.BAD_REQUEST);
        }
        repository.save(register);
        register = null;
        return new CustomResponse().getMessage("Baixa no registro", HttpStatus.CREATED);
    }

    public ResponseEntity<Registers> newEdit(UUID id, RegisterDto register) {
        Optional<Registers> Old = repository.findById(id);
        if (Old.isEmpty()) {
            return new CustomResponse().getMessage("Registro nao encontrado", HttpStatus.NOT_FOUND);
        }

        Registers newRegister = Old.get();
        newRegister.setUserName(register.nome());
        newRegister.setE_mail(register.Email());
        newRegister.setIdentifier(register.identificador());
        repository.save(newRegister);

        return new CustomResponse().getMessage("Registro Alterado com Exito", HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Registers> newDelet(UUID id) {
        Optional<Registers> regisOptional = repository.findById(id);
        if (regisOptional.isEmpty()) {
            return new CustomResponse().getMessage("Usuario nao encontrado", HttpStatus.BAD_REQUEST);
        }
        Registers registers = regisOptional.get();
        repository.delete(registers);
        return new CustomResponse().getMessage("Registro apagado de " + regisOptional.get().getUserName() + " apagado",
                HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Registers> getBYId(UUID id) {
        Optional<Registers> optional = repository.findById(id);
        return optional.isEmpty() ? new CustomResponse().getMessage("Produto nao encontrado", HttpStatus.BAD_REQUEST)
                : new CustomResponse().getMessage(optional.get(), HttpStatus.ACCEPTED);

    }

    public ResponseEntity<Registers> delAllByName(String name) {
        List<Registers> ids = new ArrayList<>();
        for (Registers registers : repository.findAll()) {
            if (registers.getUserName().equals(name)) {
                ids.add(registers);
            }
        }
        repository.deleteAll(ids);
        return new CustomResponse().getMessage("delets", HttpStatus.ALREADY_REPORTED);
    }

    public ResponseEntity<Registers> UpdateSituation(UUID id, char situacao) {
        Optional<Registers> opt = repository.findById(id);
        if (opt.isEmpty()) {
            return new CustomResponse().getMessage("Registro nao encontrado", HttpStatus.BAD_REQUEST);
        }
        UserSituation actualSituation;
        Registers register = opt.get();

        switch (situacao) {
            case 'A' -> {
                actualSituation = UserSituation.ATIVADO;
            }
            case 'D' -> {
                actualSituation = UserSituation.DESATIVADO;
            }
            case 'P' -> {
                actualSituation = UserSituation.PENDENTE;
            }
            default -> {
                return new CustomResponse().getMessage("Situacao nâo permitida", HttpStatus.BAD_REQUEST);
            }
        }
        register.setUserSituation(actualSituation);
        repository.save(register);
        register = null;
        return new CustomResponse().getMessage(
                "Situação do usuario " + opt.get().getUserName() + " alterada para " + opt.get().getUserSituation(),
                HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Registers> getCount() {
        long cont = repository.count();
        return new CustomResponse().getMessage("Total de registros => " + cont, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Registers> getCount(char c) {
        int returned = 0;
        UserSituation us;
        String st;
        switch (c) {
            case 'A' -> {
                us = UserSituation.ATIVADO;
                st = "ativados";
            }
            case 'D' -> {
                us = UserSituation.DESATIVADO;
                st = "desativados";
            }
            case 'P' -> {
                us = UserSituation.PENDENTE;
                st = "pendentes";
            }
            default -> {
                return new CustomResponse().getMessage("Situacao nâo permitida", HttpStatus.BAD_REQUEST);
            }
        }
        for (Registers register : repository.findAll()) {
            if (register.getUserSituation() == us) {
                returned++;
            }
        }
        return new CustomResponse().getMessage("O total de registros " + st + " são => " + returned,
                HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Registers> desativeAll() {
        List<Registers> listD = repository.findAll();
        for (Registers registers : listD) {
            registers.setUserSituation(UserSituation.DESATIVADO);
            repository.save(registers);
        }

        return new CustomResponse().getMessage("Todos perfis desativados", HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Registers> activeAll(){
        List<Registers> listA = repository.findAll();
        for (Registers registers : listA) {
            registers.setUserSituation(UserSituation.ATIVADO);
            repository.save(registers);
        }
        return new CustomResponse().getMessage("Todos perfis ativados", HttpStatus.OK);

    }


    public ResponseEntity<Registers> findEmail(String email){
        Optional<Registers> opt = repository.findByemail(email);
        if (opt.isEmpty()){
            return new CustomResponse().getMessage("registro nao encontrado", HttpStatus.BAD_REQUEST);
        }

        return new CustomResponse().getMessage(opt.get(),HttpStatus.ACCEPTED);
    }



}
