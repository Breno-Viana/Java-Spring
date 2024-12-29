package org.bg.picpay.picpaysimplificado.exceptions.infra;

import org.bg.picpay.picpaysimplificado.exceptions.bodies.CommercialAccountBody;
import org.bg.picpay.picpaysimplificado.exceptions.error.CommercialAccountException;
import org.bg.picpay.picpaysimplificado.exceptions.error.NoBalanceException;
import org.bg.picpay.picpaysimplificado.exceptions.bodies.NoBalance;
import org.bg.picpay.picpaysimplificado.exceptions.bodies.NotFoundUserBody;
import org.bg.picpay.picpaysimplificado.exceptions.error.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.UUID;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoBalanceException.class)
    private ResponseEntity<?> NoBalanceException(){
        NoBalance threatResponse = new NoBalance("Usuario nao possui saldo suficiente",HttpStatus.BAD_REQUEST, Instant.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
    }


    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<?> UserNotFoundException(UUID id){
        NotFoundUserBody threatResponse= new NotFoundUserBody("Usuario nao encontrado",HttpStatus.NOT_FOUND,Instant.now(),id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatResponse);
    }

    @ExceptionHandler(CommercialAccountException.class)
    private ResponseEntity<?> CommercialAccountException(){
        CommercialAccountBody commercialAccountBody = new CommercialAccountBody("Conta do tipo COMMERCIAL",HttpStatus.BAD_REQUEST,Instant.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(commercialAccountBody);
    }


}
