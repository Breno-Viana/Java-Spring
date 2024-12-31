package org.bg.picpay.picpaysimplificado.infra.exceptions.error;

import java.util.UUID;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(String message) {
        super(message);
    }

    public ClientNotFoundException() {
        super("cliente nao encontrado");
    }



}
