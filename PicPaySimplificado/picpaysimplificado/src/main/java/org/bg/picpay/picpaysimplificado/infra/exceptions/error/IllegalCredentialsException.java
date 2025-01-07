package org.bg.picpay.picpaysimplificado.infra.exceptions.error;

public class IllegalCredentialsException extends RuntimeException {
  public IllegalCredentialsException(String message) {
    super(message);
  }
}
