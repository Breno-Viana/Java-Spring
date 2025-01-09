package org.bg.picpay.picpaysimplificado;

import org.bg.picpay.picpaysimplificado.dto.utils.AddressApiConsumerDTO;
import org.bg.picpay.picpaysimplificado.dto.data.ClientDTO;
import org.bg.picpay.picpaysimplificado.model.User.Client;
import org.bg.picpay.picpaysimplificado.model.User.utils.Roles;
import org.bg.picpay.picpaysimplificado.model.User.utils.Credentials;
import org.bg.picpay.picpaysimplificado.model.address.Address;
import org.bg.picpay.picpaysimplificado.repository.ClientRepository;
import org.bg.picpay.picpaysimplificado.services.ClientService;
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

    private static final ClientDTO CLIENTE_TEST = new ClientDTO("joao", "de melo", "02113902893", "dem@gmail.com", "jota1234", 'P',new BigDecimal(1000),"46500000","rua martiniano albano de souza",33,2 );

    private static final ClientDTO CLIENTE_TEST2 = new ClientDTO("rafael", "mesquita", "7380101339338", "mesqu@gmail.com", "mesqu1234",'C',new BigDecimal(1212),"46500000","rua martiniano albano de souza",33,2);


    @Test
    void CriarClienteComEnderecoSemOServico(){

        RestTemplate rt = new RestTemplate();
        var addressDt = rt.getForEntity(String.format("http://viacep.com.br/ws/%s/json/",CLIENTE_TEST.cep()), AddressApiConsumerDTO.class);
        if (addressDt.getBody()==null){
            throw new RuntimeException();
        }
        var address = new Address(addressDt.getBody(),CLIENTE_TEST);
        var log = new Credentials(CLIENTE_TEST);
        var client = new Client(CLIENTE_TEST,address,log);


        clientRepository.save(client);

        var clientOfDatabase = clientRepository.findById(client.getId()).orElseThrow();
    }

    @Test
    void CriarClienteComEnderecoComOServico() throws Exception {
        var response = ClientService.addClient(CLIENTE_TEST2);
        Assertions.assertNotNull(response);
        System.out.println(Objects.requireNonNull(response.getBody()).toString());

    }

}
