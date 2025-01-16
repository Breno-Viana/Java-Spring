package br.bg.project.bankaccount.BankAccount.infra.exceptions.errors;

public class EqualsClientException extends RuntimeException {
    public EqualsClientException(String message) {
        super(message);
    }
    public EqualsClientException() {
    }
}
