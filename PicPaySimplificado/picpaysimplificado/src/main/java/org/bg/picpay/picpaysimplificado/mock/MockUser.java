package org.bg.picpay.picpaysimplificado.mock;

import org.bg.picpay.picpaysimplificado.dto.UserDto;
import org.bg.picpay.picpaysimplificado.model.User.AccountType;
import org.bg.picpay.picpaysimplificado.model.User.User;
import org.bg.picpay.picpaysimplificado.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class MockUser implements ApplicationRunner {
    @Autowired
    UserRepository repository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        UserDto Dto1 = new UserDto("joao", "de melo", "02993902893", "demelo@gmail.com", "jota1234", 'P',new BigDecimal(1000));
        UserDto Dto2 = new UserDto("rafael", "mesquita", "73888339338", "mesquita@gmail.com", "mesqu1234",'C',new BigDecimal(1212));
        UserDto Dto3 = new UserDto("marcos", "leao", "38993003993", "leao@gmail.com", "leao1234", 'P',new BigDecimal(12331));
        UserDto Dto4 = new UserDto("isabele", "lobos", "38388283993", "isalobos@hotmail.com", "lobo1234", 'C', new BigDecimal(12331));
        UserDto Dto5 = new UserDto("marta", "jesus", "37820129338", "marta@outlook.com", "marta1234", 'P',new BigDecimal(12010));
        UserDto Dto6 = new UserDto("manoel", "menezes", "37488391029", "mene@gmail.com", "mene1234", 'P',new BigDecimal(12212));
        UserDto Dto7 = new UserDto("joana", "souza", "37849039347", "jo@hotmail.com", "jo1234", 'C',new BigDecimal(120000));
        UserDto Dto8 = new UserDto("miguel", "matos", "38930338446", "matosm@outlook.com", "matos1234", 'P',new BigDecimal(300000));
        UserDto Dto9 = new UserDto("valentina", "santana", "37388119202", "santana@gmail.com", "ja232234", 'P',new BigDecimal(12881));
        UserDto Dto10 = new UserDto("joao", "leite", "28499302748", "leite@gmail.com", "c3443c13", 'P', new BigDecimal(21231));
        List<UserDto> dto = Arrays.asList(Dto1,Dto2,Dto3,Dto4,Dto5,Dto6,Dto7,Dto8,Dto9,Dto10);
        List<User> us = new ArrayList<>();
        for (UserDto uss : dto){
            us.add(new User(uss));
        }
       repository.saveAll(us);
    }
}
