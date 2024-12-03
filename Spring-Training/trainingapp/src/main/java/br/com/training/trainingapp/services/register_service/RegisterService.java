package br.com.training.trainingapp.services.register_service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.training.trainingapp.models.Registers;
import br.com.training.trainingapp.repository.RepositoryForService;
import br.com.training.trainingapp.services.others.utils.CustomResponse;

@Service
public class RegisterService {

    @Autowired
    private RepositoryForService repository;
 


    public List<Registers> ListRegisters() {
        return repository.findAll();
    }
   

    public ResponseEntity<Registers> newCreation(Registers register) {
        repository.save(register);
        return new CustomResponse().getMessage("Baixa no registro", HttpStatus.CREATED);
    }

    public ResponseEntity<Registers> newEdit(Long id, Registers register) {
        Optional<Registers> Old = repository.findById(id);
        if (!Old.isPresent()) {
            return new CustomResponse().getMessage("Registro nao encontrado", HttpStatus.NOT_FOUND);
        }

        Registers newRegister = Old.get();
        newRegister.setUserName(register.getUserName());
        newRegister.setE_mail(register.getE_mail());
        ;
        newRegister.setIdentifier(register.getIdentifier());
        repository.save(newRegister);

        return new CustomResponse().getMessage("Registro Alterado com Exito", HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Registers> newDelet(Long id) {
        Optional<Registers> regisOptional = repository.findById(id);
        if (!regisOptional.isPresent()) {
            return new CustomResponse().getMessage("Usuario nao encontrado", HttpStatus.BAD_REQUEST);
        }
        Registers registers = regisOptional.get();
        repository.delete(registers);
        return new CustomResponse().getMessage("Registro apagado de " + regisOptional.get().getUserName() + " apagado",
                HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Registers> getBYId(Long id) {
        Optional<Registers> optional = repository.findById(id);
        return !optional.isPresent() ? new CustomResponse().getMessage("Produto nao encontrado", HttpStatus.BAD_REQUEST)
                : new CustomResponse().getMessage(optional.get(),HttpStatus.ACCEPTED);

    }



    public ResponseEntity<Registers> delAllByName(String name){
        List<Registers> ids = new ArrayList<>();  
        for (Registers registers : repository.findAll()) {
            if (registers.getUserName().equals(name)) {
                ids.add(registers);
            }
        }
        repository.deleteAll(ids);
        return new CustomResponse().getMessage("delets",HttpStatus.ALREADY_REPORTED );
    }
}
