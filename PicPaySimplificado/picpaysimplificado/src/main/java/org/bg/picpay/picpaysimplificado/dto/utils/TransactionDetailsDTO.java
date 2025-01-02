package org.bg.picpay.picpaysimplificado.dto.utils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record TransactionDetailsDTO(UUID id,
                                    SenderAndReceiverDTO sender,
                                    SenderAndReceiverDTO receiver,
                                    BigDecimal valueOfTransaction,
                                    LocalDateTime instantTime) {
}
