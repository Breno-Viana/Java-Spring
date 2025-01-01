package br.com.training.trainingapp.utils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum UserSituation {
    ATIVADO('A'),
    DESATIVADO('D'),
    PENDENTE('P');

    private final char code;

    UserSituation(char code) {
        // TODO Auto-generated constructor stub
        this.code = code;
    }

    @JsonCreator
    public UserSituation fromCode(char code) {
        for (UserSituation cod : UserSituation.values()) {
            if (code == cod.code) {
                return cod;
            }
        }
        throw new IllegalArgumentException("Illegal Code");

    }

    @JsonValue
    public char getCode() {
        return code;
    }
}
