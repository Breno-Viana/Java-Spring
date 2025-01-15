package br.bg.project.bankaccount.BankAccount.infra.errors;

public class UnexpectedCodeException extends RuntimeException {
    public UnexpectedCodeException() {}

    public UnexpectedCodeException(String message) {
        super(message);

    }
}
