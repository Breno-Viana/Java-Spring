package org.bg.picpay.picpaysimplificado.dto.utils;

public record AddressApiConsumerDTO(String cep,
                                    String logradouro,
                                    String complemento,
                                    String unidade,
                                    String bairro,
                                    String localidade,
                                    String uf,
                                    String estado,
                                    String regiao,
                                    String ibge,
                                    String gia,
                                    String ddd,
                                    String siafi) {
    ///     "cep": "46500-000",
    ///     "logradouro": "",
    ///     "complemento": "",
    ///     "unidade": "",
    ///     "bairro": "",
    ///     "localidade": "Macaúbas",
    ///     "uf": "BA",
    ///     "estado": "Bahia",
    ///     "regiao": "Nordeste",
    ///     "ibge": "2919801",
    ///     "gia": "",
    ///     "ddd": "77",
    ///     "siafi": "3697"
}
