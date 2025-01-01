package org.bg.picpay.picpaysimplificado.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

public record TransactionDetailsDTO(UUID id,
                                    SenderAndReceiverDTO sender,
                                    SenderAndReceiverDTO receiver,
                                    BigDecimal valueOfTransaction,
                                    LocalDateTime instantTime) {
}
