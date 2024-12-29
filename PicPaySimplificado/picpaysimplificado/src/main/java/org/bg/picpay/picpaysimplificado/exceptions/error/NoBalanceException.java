package org.bg.picpay.picpaysimplificado.exceptions.error;

public class NoBalanceException extends RuntimeException {
    public NoBalanceException(String message) {
        super(message);
    }
    public NoBalanceException() {
        super("sem saldo suficiente");
    }
}
