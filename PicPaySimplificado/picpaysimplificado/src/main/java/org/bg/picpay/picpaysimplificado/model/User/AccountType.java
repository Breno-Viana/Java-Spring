package org.bg.picpay.picpaysimplificado.model.User;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;



public enum AccountType {
    COMMERCIAL('C'), PERSONAL('P');


    private final char code;


    private AccountType(char code){
        this.code = code;
    }

    public static AccountType valueDB(Character code){
        for(AccountType at : AccountType.values()){
            if (at.getCode()==code){
                return at;
            }
        }

        throw new RuntimeException();
    }
    public Character getCode(){
        return code;
    }
}
