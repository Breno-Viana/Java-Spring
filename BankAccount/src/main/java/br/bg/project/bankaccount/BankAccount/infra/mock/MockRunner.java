package br.bg.project.bankaccount.BankAccount.infra.mock;

import br.bg.project.bankaccount.BankAccount.controller.ClientController;
import br.bg.project.bankaccount.BankAccount.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MockRunner implements ApplicationRunner {


    @Autowired
    private ClientRepository repository;

    @Autowired
    private ClientController controller;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        
    }
}
