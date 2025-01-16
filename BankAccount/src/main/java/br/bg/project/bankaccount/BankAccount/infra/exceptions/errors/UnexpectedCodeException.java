package br.bg.project.bankaccount.BankAccount.infra.exceptions.errors;

public class UnexpectedCodeException extends RuntimeException {
    public UnexpectedCodeException() {}

    public UnexpectedCodeException(String message) {
        super(message);

    }
}
