package com.emprestimo.aplicacao.emprestimo_app.model.item;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.io.IOException;


@Converter
public class DetalhesConverter implements AttributeConverter<Detalhes,String>{

    private static final ObjectMapper ob = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Detalhes detalhes) {
        try {
            return ob.writeValueAsString(detalhes);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("erro ao mandar para o banco");
        }
    }

    @Override
    public Detalhes convertToEntityAttribute(String str) {
        try {
            return ob.readValue(str,Detalhes.class);
        } catch (IOException e) {
            throw new RuntimeException("erro ao pegar do banco");
        }
    }
}
