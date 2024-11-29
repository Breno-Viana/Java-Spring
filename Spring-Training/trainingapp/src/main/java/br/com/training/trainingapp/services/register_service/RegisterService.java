package br.com.training.trainingapp.services.register_service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import br.com.training.trainingapp.models.Registers;
import br.com.training.trainingapp.repository.RepositoryForService;
import br.com.training.trainingapp.services.others.CustomResponse;
import jakarta.validation.Valid;

@Service
public class RegisterService {

    @Autowired
    private RepositoryForService repository;

    public List<Registers> ListRegisters() {
        return repository.findAll();
    }

    public ResponseEntity<Object> newCreation(@RequestBody @Valid Registers register) {
        repository.save(register);
        return new CustomResponse().getMessage("Produto criado com sucesso", HttpStatus.CREATED);
    }

    public ResponseEntity<Object> newEdit(Long id, Registers register) {
        Optional<Registers> Old = repository.findById(id);
        if (!Old.isPresent()) {
            return new CustomResponse().getMessage("Registro nao encontrado", HttpStatus.NOT_FOUND);
        }

        Registers newRegister = Old.get();
        newRegister.setUserName(register.getUserName());
        newRegister.setE_mail(register.getE_mail());;
        newRegister.setIdentifier(register.getIdentifier());
        repository.save(newRegister);

        return new CustomResponse().getMessage("Registro Alterado com Exito",HttpStatus.ACCEPTED);
    }

}
