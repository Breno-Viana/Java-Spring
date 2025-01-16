package br.bg.project.bankaccount.BankAccount.infra.mock;

import br.bg.project.bankaccount.BankAccount.controller.ClientController;
import br.bg.project.bankaccount.BankAccount.dto.ClientDto;
import br.bg.project.bankaccount.BankAccount.models.Client;
import br.bg.project.bankaccount.BankAccount.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class MockRunner implements ApplicationRunner {


    @Autowired
    private ClientRepository repository;

    @Autowired
    private ClientController controller;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<ClientDto> dtos = returnDto();

        IntStream.rangeClosed(0,dtos.size()-1)
                .forEach(i->{
                    try {
                        controller.addClient(dtos.get(i));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

        System.out.println("MOCKS ADICIONADOS");
    }




    private List<ClientDto> returnDto(){
        return List.of(
                new ClientDto("claudia","de souza","souza@gmail.com","74888499483","claudia1234",new BigDecimal(10000),'P'),
                new ClientDto("raniele","melo","melo@gmail.com","23899283772","claudia1234",new BigDecimal(10000),'C'),
                new ClientDto("joao","de melo","melo@outlook.com","83999283883","claudia1234",new BigDecimal(10000),'P'),
                new ClientDto("marcos","da silva","marcos@gmail.com","83888238883","claudia1234",new BigDecimal(10000),'C'),
                new ClientDto("margarete","albuquerque","albu@gmial.com","83888238338","claudia1234",new BigDecimal(10000),'P'),
                new ClientDto("clovis","trindade","trindade@outlook.com","73883773663","claudia1234",new BigDecimal(10000),'P'),
                new ClientDto("josias","matarazzo","matarazzo@gmail.com","73744882993","claudia1234",new BigDecimal(10000),'C'),
                new ClientDto("mikael","de jesus","amem@gmail.com","20939374882","claudia1234",new BigDecimal(10000),'P'),
                new ClientDto("elis","regina","rege@gmail.com","20383928334","claudia1234",new BigDecimal(10000),'P'),
                new ClientDto("matheus","de souza","mat@outlook.com","27733840383","claudia1234",new BigDecimal(10000),'P')
        );
    }
}
