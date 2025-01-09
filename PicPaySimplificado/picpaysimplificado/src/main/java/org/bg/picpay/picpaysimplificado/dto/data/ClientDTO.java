package org.bg.picpay.picpaysimplificado.dto.data;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.math.BigDecimal;
import java.util.Set;

public record ClientDTO(@NotBlank String firstname,
                        @NotBlank String lastname,
                        @NotBlank String document,
                        @NotBlank String email,
                        @NotBlank String password,
                        @NotNull Character clientType,
                        @NotNull BigDecimal balance,
                        @NotBlank String cep,
                        @NotBlank String street,
                        @NotNull Integer Number,
                        Integer codeRole) {

}
