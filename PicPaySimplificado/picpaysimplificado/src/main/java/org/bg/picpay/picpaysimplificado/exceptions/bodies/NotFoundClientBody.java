package org.bg.picpay.picpaysimplificado.exceptions.bodies;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
public class NotFoundClientBody {
    private String message;
    private HttpStatus status;
    private Instant instant;
    //private UUID id_not_founded;


    public NotFoundClientBody() {
    }

    public NotFoundClientBody(String message, HttpStatus status, Instant instant ) {
        this.message = message;
        this.status = status;
        this.instant = instant;
       // this.id_not_founded = id_not_founded;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

   /* public UUID getId_not_founded() {
        return id_not_founded;
    }

    public void setId_not_founded(UUID id_not_founded) {
        this.id_not_founded = id_not_founded;
    }*/
}
