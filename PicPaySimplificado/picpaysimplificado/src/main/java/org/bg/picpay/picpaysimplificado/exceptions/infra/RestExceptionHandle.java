package org.bg.picpay.picpaysimplificado.exceptions.infra;

import org.bg.picpay.picpaysimplificado.exceptions.NoBalanceException;
import org.bg.picpay.picpaysimplificado.exceptions.bodies.NoBalance;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.math.BigDecimal;
import java.time.Instant;

@ControllerAdvice
public class RestExceptionHandle extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoBalanceException.class)
    private ResponseEntity<?> NoBalanceException(BigDecimal currentBalance){
        NoBalance threatResponse = new NoBalance("Usuario nao possui saldo suficiente",HttpStatus.BAD_REQUEST, Instant.now(),currentBalance);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
    }
}
