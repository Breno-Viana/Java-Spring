package org.bg.picpay.picpaysimplificado.model.address;

import org.bg.picpay.picpaysimplificado.dto.utils.AddressApiConsumerDTO;
import org.bg.picpay.picpaysimplificado.dto.data.ClientDTO;
import org.springframework.stereotype.Component;

@Component
public class Address {
    public Address(AddressApiConsumerDTO dto, ClientDTO clientDTO){
        this.cep=dto.cep();
        this.bairro=dto.bairro();
        this.cidade=dto.localidade();
        this.estado= dto.estado();
        this.regiao=dto.regiao();
        this.uf=dto.uf();
        this.numeroDaCasa=clientDTO.houseNumber();
        this.rua= clientDTO.streetName();
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


    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumeroDaCasa() {
        return numeroDaCasa;
    }

    public void setNumeroDaCasa(Integer numeroDaCasa) {
        this.numeroDaCasa = numeroDaCasa;
    }
}
