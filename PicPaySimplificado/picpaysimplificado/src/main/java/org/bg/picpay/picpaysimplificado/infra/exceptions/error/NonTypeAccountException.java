package org.bg.picpay.picpaysimplificado.infra.exceptions.error;

public class NonTypeAccountException extends RuntimeException{
    public NonTypeAccountException(String message){super(message);}

    public NonTypeAccountException() {
    }
}
