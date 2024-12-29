package org.bg.picpay.picpaysimplificado.exceptions;

public class NoBalanceException extends RuntimeException {
    public NoBalanceException(String message) {
        super(message);
    }
    public NoBalanceException() {
        super("sem saldo suficiente");
    }
}
