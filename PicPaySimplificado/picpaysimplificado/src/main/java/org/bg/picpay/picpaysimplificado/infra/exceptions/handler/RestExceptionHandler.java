package org.bg.picpay.picpaysimplificado.infra.exceptions.handler;

import org.bg.picpay.picpaysimplificado.infra.exceptions.bodies.CommercialAccountBody;
import org.bg.picpay.picpaysimplificado.infra.exceptions.bodies.NotFoundClientBody;
import org.bg.picpay.picpaysimplificado.infra.exceptions.bodies.NoBalance;
import org.bg.picpay.picpaysimplificado.infra.exceptions.error.*;
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
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Considere inserir um tipo de conta valido [C] COMMERCIAL/ [P] PERSONAL");
    }

    @ExceptionHandler(EqualsClientException.class)
    private ResponseEntity<?> EqualsClientException(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nao é possível fazer uma transferência para si mesmo");
    }

    @ExceptionHandler(NoValidBodyException.class)
    private ResponseEntity<?> NoValidBody(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insira um corpo valido");
    }


}
