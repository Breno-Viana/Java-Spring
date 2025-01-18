package br.bg.project.bankaccount.BankAccount.dto;


import br.bg.project.bankaccount.BankAccount.models.enums.Roles;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record ClientDto(@NotBlank String firstname,
                        @NotBlank String lastname,
                        @NotBlank @Email String email,
                        @NotBlank String document,
                        @NotBlank String password,
                        BigDecimal amount,
                        Character clientType,
                        Roles role) {
}
