package br.com.apirest.ApiRestAPP.Utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseDrops {
    public static ResponseEntity<Object> GenerateMessages(String message,HttpStatus statusCode){

        return new ResponseEntity<Object>(message,statusCode);

    }
}
