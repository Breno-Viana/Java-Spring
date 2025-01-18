package br.bg.project.bankaccount.BankAccount.infra.exceptions.handler;

import br.bg.project.bankaccount.BankAccount.infra.exceptions.errors.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class Exceptions {


    @ExceptionHandler(ClientNotFoundException.class)
    private ResponseEntity<?> ClientNotFound(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("cliente nao encontrado");
    }


    @ExceptionHandler(CommencialAccountException.class)
    private ResponseEntity<?> CommercialAccount(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("contas do tipo comercial nao podem realizar transferencias");
    }

    @ExceptionHandler(DuplicateExceptions.class)
    private ResponseEntity<?> Duplicate(){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ja existe um cliente com esse documento ou email");
    }

    @ExceptionHandler(EqualsClientException.class)
    private ResponseEntity<?> Equals(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("nao é permitido efetuar uma transferencia para si mesmo");
    }


    @ExceptionHandler(UnexpectedCodeException.class)
    private ResponseEntity<?> Unexpected(){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("tipo de conta nao suportado");
    }

    @ExceptionHandler(NoBalanceException.class)
    private ResponseEntity<?> NoBalance(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario nao possui saldo suficiente");
    }

    @ExceptionHandler(ClientAlreadyExistsException.class)
    private ResponseEntity<?> ClientAlreadyExists(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ja existe um cliente com esse documento ou email");
    }
}
