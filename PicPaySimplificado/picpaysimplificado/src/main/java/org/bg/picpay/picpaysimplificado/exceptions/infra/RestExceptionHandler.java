package org.bg.picpay.picpaysimplificado.exceptions.infra;

import org.bg.picpay.picpaysimplificado.exceptions.bodies.CommercialAccountBody;
import org.bg.picpay.picpaysimplificado.exceptions.bodies.NotFoundClientBody;
import org.bg.picpay.picpaysimplificado.exceptions.error.*;
import org.bg.picpay.picpaysimplificado.exceptions.bodies.NoBalance;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoBalanceException.class)
    private ResponseEntity<?> NoBalanceException(){
        NoBalance threatResponse = new NoBalance("Usuario nao possui saldo suficiente",HttpStatus.BAD_REQUEST, Instant.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
    }


    @ExceptionHandler(CommercialAccountException.class)
    private ResponseEntity<?> CommercialAccountException(){
        CommercialAccountBody commercialAccountBody = new CommercialAccountBody("Conta do tipo COMMERCIAL",HttpStatus.BAD_REQUEST,Instant.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(commercialAccountBody);
    }


    @ExceptionHandler(ClientNotFoundException.class)
    private ResponseEntity<?> ClientNotFoundException(){
        NotFoundClientBody clientBody = new NotFoundClientBody("cliente nao encontrado",HttpStatus.NOT_FOUND,Instant.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(clientBody);
    }

    @ExceptionHandler(NullAddressException.class)
    private ResponseEntity<?> NullAddressException(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("no address content");
    }

    @ExceptionHandler(NonTypeAccountException.class)
    private ResponseEntity<?> NoTypeAccountException(){
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Tipo de conta nao suportado");
    }


}
