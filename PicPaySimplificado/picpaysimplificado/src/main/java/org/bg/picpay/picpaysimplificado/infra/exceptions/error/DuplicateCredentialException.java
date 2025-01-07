package org.bg.picpay.picpaysimplificado.infra.exceptions.error;

public class DuplicateCredentialException extends RuntimeException {
  public DuplicateCredentialException(String message) {
    super(message);
  }
}
