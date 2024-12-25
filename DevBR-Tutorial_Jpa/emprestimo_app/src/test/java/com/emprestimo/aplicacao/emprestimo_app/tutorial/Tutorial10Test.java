package com.emprestimo.aplicacao.emprestimo_app.tutorial;

import com.emprestimo.aplicacao.emprestimo_app.model.pessoa.Pessoa;
import com.emprestimo.aplicacao.emprestimo_app.model.pessoa.Repository.PessoaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest
public class Tutorial10Test {

    @Autowired
    private PessoaRepository pessoaRepository;


    @Test
    void BuscarPessoaPorEmail(){
        var pessoa = new Pessoa();
        pessoa.setName("Elis");
        pessoa.setEmail("elisa@test.com");
        pessoaRepository.save(pessoa);

        var referencia = new Pessoa();
        referencia.setEmail("elisa@test.com");
        //pessoaRepository.save(referencia);
        var exemplo = Example.of(referencia);
        var pessoaRepo = pessoaRepository.findOne(exemplo).orElseThrow();

        Assertions.assertEquals("elisa@test.com",pessoaRepo.getEmail());


    }

    @Test
    void acharMaisDeUmComOExemplo(){
        var pessoa = new Pessoa();
        pessoa.setName("Elis");
        pessoa.setEmail("elis@test.com");
        pessoaRepository.save(pessoa);
        var pessoa2 = new Pessoa();
        pessoa2.setName("barcola");
        pessoa2.setEmail("elis@test.com");
        pessoaRepository.save(pessoa2);
        var pessoa3 = new Pessoa();
        pessoa3.setName("jota");
        pessoa3.setEmail("jao@gmai.com");
        pessoaRepository.save(pessoa3);

        var referencia = new Pessoa();
        referencia.setEmail("elis@test.com");
        var pessoaReferencia = Example.of(referencia);
        var ListaDeReferencias = pessoaRepository.findAll(pessoaReferencia);
        Assertions.assertEquals(2,ListaDeReferencias.size());
        Assertions.assertEquals(pessoa,ListaDeReferencias.getFirst());

    }


    @Test
    void BuscarPorDominioDoEmail(){
        var pessoa = new Pessoa();
        pessoa.setEmail("carlos@test.com");
        pessoa.setName("carlos");

        pessoaRepository.save(pessoa);

        var referencia = new Pessoa();
        referencia.setEmail("@test.com");

        var matcher = ExampleMatcher
                .matching()
                .withMatcher("email",endsWith());

        var exemplo = Example.of(referencia,matcher);


        var pessoaDoRepositorio = pessoaRepository.findAll(exemplo);

        Assertions.assertEquals(1,pessoaDoRepositorio.size());
        Assertions.assertEquals(pessoa.getEmail(),pessoaDoRepositorio.getFirst().getEmail());
    }
}
