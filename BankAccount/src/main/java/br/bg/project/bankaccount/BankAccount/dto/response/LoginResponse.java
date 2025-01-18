package br.bg.project.bankaccount.BankAccount.dto.response;

import java.time.Instant;

public record LoginResponse(String token, Instant expiresAt) {
}
