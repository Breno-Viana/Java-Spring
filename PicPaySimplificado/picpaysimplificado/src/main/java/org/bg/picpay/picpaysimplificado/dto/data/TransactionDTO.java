package org.bg.picpay.picpaysimplificado.dto.data;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionDTO(UUID senderID,
                             UUID receiverID,
                             BigDecimal amount) {
}
