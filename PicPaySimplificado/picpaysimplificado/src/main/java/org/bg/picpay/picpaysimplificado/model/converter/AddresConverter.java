package org.bg.picpay.picpaysimplificado.model.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.bg.picpay.picpaysimplificado.model.address.Address;

import java.util.concurrent.ExecutionException;

@Converter
public class AddresConverter implements AttributeConverter<Address, String> {
    @Override
    public String convertToDatabaseColumn(Address address) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(address);
        }catch (Exception e){
       throw new RuntimeException();
        }
    }

    @Override
    public Address convertToEntityAttribute(String s) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(s,Address.class);
        }catch (Exception e) {
            return null;
        }
    }
}
