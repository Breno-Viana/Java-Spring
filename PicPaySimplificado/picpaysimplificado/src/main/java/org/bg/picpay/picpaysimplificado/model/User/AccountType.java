package org.bg.picpay.picpaysimplificado.model.User;

import org.bg.picpay.picpaysimplificado.exceptions.error.NonTypeAccountException;


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

        throw new NonTypeAccountException();
    }
    public Character getCode(){
        return code;
    }
}
