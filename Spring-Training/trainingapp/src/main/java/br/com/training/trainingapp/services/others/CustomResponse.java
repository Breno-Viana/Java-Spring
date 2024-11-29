package br.com.training.trainingapp.services.others;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CustomResponse {
    public ResponseEntity<Object> getMessage(String message, HttpStatus code){
        return new ResponseEntity<>(message,code);
    }
}
