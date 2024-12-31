package org.bg.picpay.picpaysimplificado.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ClientDTO(@NotBlank String firstName,
                        @NotBlank String lastName,
                        @NotBlank String document,
                        @NotBlank String email,
                        @NotBlank String passWord,
                        @NotNull Character clientType,
                        @NotNull BigDecimal balance,
                        @NotBlank String cep,
                        @NotBlank String streetName,
                        @NotNull Integer houseNumber) {

}
