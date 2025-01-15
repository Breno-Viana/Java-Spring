package br.bg.project.bankaccount.BankAccount.infra.errors;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(String message) {
        super(message);
    }
    public ClientNotFoundException() {

    }
}
