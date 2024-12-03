package br.com.training.trainingapp.services.others.utils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum UserSituation {
    ATIVO('A'),
    DESATIVO('D'),
    PENDENTE('P');

    private char code;

    private UserSituation(char code) {
        // TODO Auto-generated constructor stub
        this.code = code;
    }

    @JsonCreator
    public UserSituation fromCode(char code) {
        for (UserSituation coode : UserSituation.values()) {
            if (code == coode.code) {
                return coode;
            }
        }
        throw new IllegalArgumentException("Illegal Code");

    }

    @JsonValue
    public char getCode() {
        return code;
    }
}
