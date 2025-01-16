package br.bg.project.bankaccount.BankAccount.infra.exceptions.errors;

public class CommencialAccountException extends RuntimeException {
    public CommencialAccountException(String message) {
        super(message);
    }
    public CommencialAccountException() {

    }
}
