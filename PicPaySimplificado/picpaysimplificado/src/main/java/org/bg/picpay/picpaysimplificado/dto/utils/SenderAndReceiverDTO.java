package org.bg.picpay.picpaysimplificado.dto.utils;

import org.bg.picpay.picpaysimplificado.model.User.utils.AccountType;

public record SenderAndReceiverDTO(String firstName,
                                   String lastName,
                                   AccountType accountType) {
}
