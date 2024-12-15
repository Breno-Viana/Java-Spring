package br.com.training.trainingapp.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.training.trainingapp.models.Registers;

public class CustomResponse {
    public ResponseEntity<Registers> getMessage(String message, HttpStatus code){
        return new ResponseEntity(message,code);
    }

    public ResponseEntity<Registers> getMessage(Object object, HttpStatus code){
        return new ResponseEntity(object,code);
    }
}
