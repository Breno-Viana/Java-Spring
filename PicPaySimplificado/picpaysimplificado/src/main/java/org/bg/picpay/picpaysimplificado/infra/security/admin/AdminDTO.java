package org.bg.picpay.picpaysimplificado.infra.security.admin;

import org.bg.picpay.picpaysimplificado.model.User.utils.ClientRoles;

public record AdminDTO(String email,
                       String document,
                       String password,
                       ClientRoles role) {
}
