package org.bg.picpay.picpaysimplificado.dto.request;

import java.time.Instant;


public record LoginResponse(String Token, Instant expiresAt) {
}
