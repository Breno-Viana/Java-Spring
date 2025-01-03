package org.bg.picpay.picpaysimplificado.dto.utils;

import org.bg.picpay.picpaysimplificado.model.User.utils.ClientRoles;

public record AdminDTO(String email,
                       String document,
                       String password,
                       ClientRoles role) {
}
