package org.bg.picpay.picpaysimplificado.dto.requests;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(@NotBlank
                           String login,

                           @NotBlank
                           String password) {
}
