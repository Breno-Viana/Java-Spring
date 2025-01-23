package br.bg.project.bankaccount.BankAccount.models.enums;

public enum Roles {
    ADMIN("ROLE_ADMIN"),
    BASIC("ROLE_BASIC");

    private final String role;

    Roles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
