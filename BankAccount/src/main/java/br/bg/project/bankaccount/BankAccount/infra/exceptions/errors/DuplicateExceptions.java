package br.bg.project.bankaccount.BankAccount.infra.exceptions.errors;

import br.bg.project.bankaccount.BankAccount.models.Client;

public class DuplicateExceptions extends RuntimeException {
    public DuplicateExceptions(String message) {
        super(message);
    }

    public DuplicateExceptions() {
    }

    public DuplicateExceptions(Client client) {

    }
}
