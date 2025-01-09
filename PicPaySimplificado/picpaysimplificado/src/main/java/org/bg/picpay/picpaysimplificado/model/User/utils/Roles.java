package org.bg.picpay.picpaysimplificado.model.User.utils;



import javax.management.relation.RoleNotFoundException;
import java.util.Objects;


public enum Roles {
    ADMIN(1,"admin"),
    BASIC(2,"basic");


    private final Integer code;

Roles(Integer code, String basic){
    this.code=code;
}


    public static Roles valuesRole(Integer code) throws RoleNotFoundException {
        for (Roles cl : Roles.values()){
            if (Objects.equals(cl.code, code)){
                return cl;
            }
        }
        throw new RoleNotFoundException("Role nao encontrada");
    }


}
