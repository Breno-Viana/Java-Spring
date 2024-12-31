package org.bg.picpay.picpaysimplificado.mock;

import org.bg.picpay.picpaysimplificado.dto.ClientDTO;
import org.bg.picpay.picpaysimplificado.repository.ClientRepository;
import org.bg.picpay.picpaysimplificado.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.rangeClosed;

@Component
public class MockUser implements ApplicationRunner {


    @Autowired
    private ClientService clientService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ClientDTO Dto1 = new ClientDTO("joao", "de melo", "02993902893", "demelo@gmail.com", "jota1234", 'P',new BigDecimal(1000),"46500000","rua y",21);
        ClientDTO Dto2 = new ClientDTO("rafael", "mesquita", "73888339338", "mesquita@gmail.com", "mesqu1234",'C',new BigDecimal(1212),"40050320","rua y",21);
        ClientDTO Dto3 = new ClientDTO("marcos", "leao", "38993003993", "leao@gmail.com", "leao1234", 'P',new BigDecimal(12331),"46500000","rua y",21);
        ClientDTO Dto4 = new ClientDTO("isabele", "lobos", "38388283993", "isalobos@hotmail.com", "lobo1234", 'C', new BigDecimal(12331),"46500000","rua y",21);
        ClientDTO Dto5 = new ClientDTO("marta", "jesus", "37820129338", "marta@outlook.com", "marta1234", 'P',new BigDecimal(12010),"46500000","rua y",21);
        ClientDTO Dto6 = new ClientDTO("manoel", "menezes", "37488391029", "mene@gmail.com", "mene1234", 'P',new BigDecimal(12212),"46500000","rua y",21);
        ClientDTO Dto7 = new ClientDTO("joana", "souza", "37849039347", "jo@hotmail.com", "jo1234", 'C',new BigDecimal(120000),"46500000","rua y",21);
        ClientDTO Dto8 = new ClientDTO("miguel", "matos", "38930338446", "matosm@outlook.com", "matos1234", 'P',new BigDecimal(300000),"46500000","rua y",21);
        ClientDTO Dto9 = new ClientDTO("valentina", "santana", "37388119202", "santana@gmail.com", "ja232234", 'P',new BigDecimal(12881),"46500000","rua y",21);
        ClientDTO Dto10 = new ClientDTO("joao", "leite", "28499302748", "leite@gmail.com", "c3443c13", 'P', new BigDecimal(21231),"46500000","rua y",21);

        List<ClientDTO> ls = Arrays.asList(Dto1,Dto2,Dto3,Dto4,Dto5,Dto6,Dto7,Dto8,Dto9,Dto10);
        rangeClosed(0,9).forEach((i)->{
            ClientService.addClient(ls.get(i));
        });
    }
}
