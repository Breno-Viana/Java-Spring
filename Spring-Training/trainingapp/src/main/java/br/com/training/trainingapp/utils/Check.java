package br.com.training.trainingapp.utils;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.training.trainingapp.repository.RepositoryForService;
import br.com.training.trainingapp.models.*;




@Component
public class Check {

    @Autowired
    RepositoryForService repository;

    public boolean CheckDuplicate(Registers register) {
        List<Registers> ls = new ArrayList<>();

        for (Registers registers : repository.findAll()) {
            if (register.getIdentifier().trim().equals(registers.getIdentifier().trim())||register.getEmail().trim().equals(registers.getEmail().trim())) {
                ls.add(register);
            }
        }

        return !ls.isEmpty();
    }
}
