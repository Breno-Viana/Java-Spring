package org.bg.picpay.picpaysimplificado.infra.exceptions.error;

public class NoValidBodyException extends RuntimeException {
    public NoValidBodyException(String message) {
        super(message);
    }

    public NoValidBodyException() {
    }
}
