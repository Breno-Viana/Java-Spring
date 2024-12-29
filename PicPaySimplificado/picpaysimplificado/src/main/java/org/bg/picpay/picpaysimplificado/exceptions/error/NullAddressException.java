package org.bg.picpay.picpaysimplificado.exceptions.error;

public class NullAddressException extends RuntimeException {
    public NullAddressException(String message) {
        super(message);
    }

    public NullAddressException() {
    }
}
