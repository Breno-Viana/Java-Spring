package org.bg.picpay.picpaysimplificado.exceptions.error;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException() {
    }

    public UserNotFoundException(UUID i){
        super(i.toString());
    }


}
