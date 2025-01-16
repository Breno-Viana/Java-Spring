package br.bg.project.bankaccount.BankAccount.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionResponse(Sender sender, Receiver receiver, BigDecimal value, LocalDateTime dateTime) {
}
