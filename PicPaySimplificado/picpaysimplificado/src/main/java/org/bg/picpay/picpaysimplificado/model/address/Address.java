package org.bg.picpay.picpaysimplificado.model.address;

import lombok.Getter;
import lombok.Setter;
import org.bg.picpay.picpaysimplificado.dto.utils.AddressApiConsumerDTO;
import org.bg.picpay.picpaysimplificado.dto.data.ClientDTO;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class Address {
    public Address(AddressApiConsumerDTO dto, ClientDTO clientDTO){
        this.cep=dto.cep();
        this.bairro=dto.bairro();
        this.cidade=dto.localidade();
        this.estado= dto.estado();
        this.regiao=dto.regiao();
        this.uf=dto.uf();
        this.numeroDaCasa=clientDTO.Number();
        this.rua= clientDTO.street();
    }

    public Address() {
    }




    @Override
    public String toString() {
        return "Address{" +
                "cep='" + cep + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", uf='" + uf + '\'' +
                ", estado='" + estado + '\'' +
                ", regiao='" + regiao + '\'' +
                ", rua='" + rua + '\'' +
                ", numeroDaCasa=" + numeroDaCasa +
                '}';
    }

    private String cep;
    private String bairro;
    private String cidade;
    private String uf;
    private String estado;
    private String regiao;
    private String rua;
    private Integer numeroDaCasa;


}
