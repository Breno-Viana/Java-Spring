package br.bg.project.bankaccount.BankAccount.infra.errors;

public class EqualsClientException extends RuntimeException {
    public EqualsClientException(String message) {
        super(message);
    }
    public EqualsClientException() {
    }
}
