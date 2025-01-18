package br.bg.project.bankaccount.BankAccount.infra.exceptions.errors;

public class ClientAlreadyExistsException extends RuntimeException {
    public ClientAlreadyExistsException(String message) {
        super(message);
    }
    public ClientAlreadyExistsException() {
    }
}
