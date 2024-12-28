package org.bg.picpay.picpaysimplificado.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionDto(UUID senderID,
                             UUID receiverID,
                             BigDecimal amount) {
}
