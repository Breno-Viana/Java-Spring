package org.bg.picpay.picpaysimplificado.exceptions.bodies;

import org.springframework.http.HttpStatus;

import java.time.Instant;

public class CommercialAccountBody {
    private String message;
    private HttpStatus status;
    private Instant instantError;

    public CommercialAccountBody(String message, HttpStatus status, Instant instantError) {
        this.message = message;
        this.status = status;
        this.instantError = instantError;
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

    public Instant getInstantError() {
        return instantError;
    }

    public void setInstantError(Instant instantError) {
        this.instantError = instantError;
    }
}
