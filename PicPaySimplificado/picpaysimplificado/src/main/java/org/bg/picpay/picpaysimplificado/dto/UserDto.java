package org.bg.picpay.picpaysimplificado.dto;


import org.bg.picpay.picpaysimplificado.model.User.AccountType;

import java.math.BigDecimal;

public record UserDto(String firstName,
                      String lastName,
                      String document,
                      String email,
                      String passWord,
                      Character userType,
                      BigDecimal balance) {
}
