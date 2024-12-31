package org.bg.picpay.picpaysimplificado.infra.exceptions.bodies;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;

@Component
public class NoBalance {
    private String message;
    private HttpStatus status;
    private Instant instantTime;
    private BigDecimal currentBalance;

    public NoBalance() {
    }

    public NoBalance(String message, HttpStatus status, Instant instantTime) {
        this.message = message;
        this.status = status;
        this.instantTime = instantTime;
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

    public Instant getInstantTime() {
        return instantTime;
    }

    public void setInstantTime(Instant instantTime) {
        this.instantTime = instantTime;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }
}
