package br.bg.project.bankaccount.BankAccount.models;

import br.bg.project.bankaccount.BankAccount.infra.exceptions.errors.UnexpectedCodeException;

public enum ClientType {
    COMMERCIAL('C'),
    PERSONAL('P');

    private Character code;
    ClientType(Character code){
        this.code=code;
    }

    public Character getCode(){
        return code;
    }

    public static ClientType getTypeOfCode(Character code){
        for (ClientType ct : ClientType.values()){
            if (ct.getCode() == code){
                return ct;
            }
        }

        throw new UnexpectedCodeException();
    }
}
