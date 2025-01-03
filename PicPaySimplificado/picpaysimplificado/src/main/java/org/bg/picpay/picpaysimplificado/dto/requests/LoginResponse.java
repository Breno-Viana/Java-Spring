package org.bg.picpay.picpaysimplificado.dto.requests;

import java.time.Instant;


public record LoginResponse(String Token, Instant expiresAt) {
}
