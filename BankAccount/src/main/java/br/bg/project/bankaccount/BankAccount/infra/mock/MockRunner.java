package br.bg.project.bankaccount.BankAccount.infra.mock;

import br.bg.project.bankaccount.BankAccount.controller.ClientController;
import br.bg.project.bankaccount.BankAccount.dto.ClientDto;
import br.bg.project.bankaccount.BankAccount.models.Client;
import br.bg.project.bankaccount.BankAccount.models.Login;
import br.bg.project.bankaccount.BankAccount.models.enums.Roles;
import br.bg.project.bankaccount.BankAccount.repository.ClientRepository;
import br.bg.project.bankaccount.BankAccount.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private LoginRepository loginRepository;

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

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        var admin = new Login("admin",encoder.encode("admin1234"),Roles.ADMIN);
        loginRepository.save(admin);

        System.out.println("ADMINISTRADOR ADICIONADO");
    }




    private List<ClientDto> returnDto(){
        return List.of(
                new ClientDto("claudia","de souza","souza@gmail.com","74888499483","claudia1234",new BigDecimal(10000),'P',Roles.BASIC),
                new ClientDto("raniele","melo","melo@gmail.com","23899283772","claudia1234",new BigDecimal(10000),'C',Roles.BASIC),
                new ClientDto("joao","de melo","melo@outlook.com","83999283883","claudia1234",new BigDecimal(10000),'P',Roles.BASIC),
                new ClientDto("marcos","da silva","marcos@gmail.com","83888238883","claudia1234",new BigDecimal(10000),'C',Roles.BASIC),
                new ClientDto("margarete","albuquerque","albu@gmial.com","83888238338","claudia1234",new BigDecimal(10000),'P',Roles.BASIC),
                new ClientDto("clovis","trindade","trindade@outlook.com","73883773663","claudia1234",new BigDecimal(10000),'P',Roles.BASIC),
                new ClientDto("josias","matarazzo","matarazzo@gmail.com","73744882993","claudia1234",new BigDecimal(10000),'C',Roles.BASIC),
                new ClientDto("mikael","de jesus","amem@gmail.com","20939374882","claudia1234",new BigDecimal(10000),'P',Roles.BASIC),
                new ClientDto("elis","regina","rege@gmail.com","20383928334","claudia1234",new BigDecimal(10000),'P',Roles.BASIC),
                new ClientDto("matheus","de souza","mat@outlook.com","27733840383","claudia1234",new BigDecimal(10000),'P',Roles.BASIC)
        );
    }
}
