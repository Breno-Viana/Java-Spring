package org.bg.picpay.picpaysimplificado;

import org.bg.picpay.picpaysimplificado.dto.AddressApiConsumerDTO;
import org.bg.picpay.picpaysimplificado.dto.ClientDTO;
import org.bg.picpay.picpaysimplificado.model.User.Client;
import org.bg.picpay.picpaysimplificado.model.address.Address;
import org.bg.picpay.picpaysimplificado.repository.ClientRepository;
import org.bg.picpay.picpaysimplificado.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Objects;

@SpringBootTest
class PicpaysimplificadoApplicationTests {



    @Autowired
    private ClientRepository clientRepository;


    @Test
    void TesteDoUsoDaApiViaCepComORestTemplate(){
        RestTemplate rt = new RestTemplate();
        String cep = "46500000";
        var address = rt.getForEntity(String.format("http://viacep.com.br/ws/%s/json/",cep), AddressApiConsumerDTO.class);

        Assertions.assertNotNull(address.getBody());
        Assertions.assertEquals("77",address.getBody().ddd());
    }



    @Test
    void CriarClienteComEnderecoSemOServico(){
        var cliente = new ClientDTO("joao", "de melo", "02993902893", "demelo@gmail.com", "jota1234", 'P',new BigDecimal(1000),"46500000","rua martiniano albano de souza",33);

        RestTemplate rt = new RestTemplate();
        var addressDt = rt.getForEntity(String.format("http://viacep.com.br/ws/%s/json/",cliente.cep()), AddressApiConsumerDTO.class);
        if (addressDt.getBody()==null){
            throw new RuntimeException();
        }
        var address = new Address(addressDt.getBody(),cliente);
        var client = new Client(cliente,address);


        clientRepository.save(client);
        System.out.println(client.getAddress().toString());
        var clientOfDatabase = clientRepository.findById(client.getId()).orElseThrow();

       Assertions.assertEquals(33,clientOfDatabase.getAddress().getNumeroDaCasa());
    }

    @Test
    void CriarClienteComEnderecoComOServico(){
        var cliente = new ClientDTO("joao", "de melo", "02993902893", "demelo@gmail.com", "jota1234", 'P',new BigDecimal(1000),"46500000","rua martiniano albano de souza",33);
        var response = UserService.addUser(cliente);
        Assertions.assertNotNull(response);
        System.out.println(Objects.requireNonNull(response.getBody()).toString());

    }

}
