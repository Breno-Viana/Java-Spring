package org.bg.picpay.picpaysimplificado.model.User.utils;

import javax.management.relation.RoleNotFoundException;
import java.util.Objects;

public enum ClientRoles {
    ADMIN("admin"),
    BASIC("basic");

    private final String nameRole;

    ClientRoles(String nameRole) {
        this.nameRole = nameRole;
    }


    public ClientRoles valuesRole(String role) throws RoleNotFoundException {
        for (ClientRoles cl : ClientRoles.values()){
            if (Objects.equals(role, cl.nameRole)){
                return this.valuesRole(role);
            }
        }
        throw new RoleNotFoundException("Role nao encontrada");
    }
}
