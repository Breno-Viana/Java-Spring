package org.bg.picpay.picpaysimplificado.dto;


import java.math.BigDecimal;

public record ClientDTO(String firstName,
                        String lastName,
                        String document,
                        String email,
                        String passWord,
                        Character clientType,
                        BigDecimal balance,
                        String cep,
                        String streetName,
                        Integer houseNumber) {

}
