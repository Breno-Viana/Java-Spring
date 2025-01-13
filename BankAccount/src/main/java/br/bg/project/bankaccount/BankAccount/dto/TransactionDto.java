package br.bg.project.bankaccount.BankAccount.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionDto(UUID sender,
                             UUID receiver,
                             BigDecimal value) {
}
