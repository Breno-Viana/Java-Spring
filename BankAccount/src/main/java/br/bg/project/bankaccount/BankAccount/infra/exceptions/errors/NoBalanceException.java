package br.bg.project.bankaccount.BankAccount.infra.exceptions.errors;

public class NoBalanceException extends RuntimeException {
    public NoBalanceException(String message) {
        super(message);
    }
    public NoBalanceException() {
    }
}
