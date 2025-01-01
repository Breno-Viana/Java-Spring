package org.bg.picpay.picpaysimplificado.infra.exceptions.error;

public class NoBalanceException extends RuntimeException {
    public NoBalanceException(String message) {
        super(message);
    }
    public NoBalanceException() {
        super("sem saldo suficiente");
    }
}
