package br.com.training.trainingapp.dto;

import br.com.training.trainingapp.utils.UserSituation;
import lombok.Builder;


@Builder
public record RegisterDto(String nome, String identificador, String Email, UserSituation situacao) {

    public RegisterDto{
        if(situacao == null){
            situacao = UserSituation.PENDENTE;
        }
    }
}
