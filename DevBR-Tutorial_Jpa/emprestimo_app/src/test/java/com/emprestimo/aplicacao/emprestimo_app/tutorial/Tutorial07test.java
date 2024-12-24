package com.emprestimo.aplicacao.emprestimo_app.tutorial;


import com.emprestimo.aplicacao.emprestimo_app.model.item.Item;
import com.emprestimo.aplicacao.emprestimo_app.model.item.repository.ItemRepository;
import com.emprestimo.aplicacao.emprestimo_app.model.pessoa.Pessoa;
import com.emprestimo.aplicacao.emprestimo_app.model.pessoa.Repository.PessoaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Tutorial07test {


    @Autowired
    private PessoaRepository pessoaRepository;


    @Autowired
    private ItemRepository itemRepository;

    @Test
    void BucarPessoaPorEmail(){
        var pessoa = new Pessoa();
        pessoa.setName("ana");
        pessoa.setEmail("ana@gmail.com");
        pessoaRepository.save(pessoa);

        var emailTest = pessoaRepository.findByEmail("ana@gmail.com").orElseThrow();
        Assertions.assertEquals("ana@gmail.com",emailTest.getEmail());
    }


    @Test
    void BuscaPeloNomeDoItem(){
        var item = new Item();
        item.setName("Zip Drive");
        itemRepository.save(item);

        var pessoa = new Pessoa();
        pessoa.setName("ana");
        pessoa.setEmail("ana@gmail.com");
        pessoa.getItens().add(item);
        pessoaRepository.save(pessoa);

        var pessoas = pessoaRepository.findByItens_name("Zip Drive");
        Assertions.assertEquals(pessoa.getId(),pessoas.getFirst().getId());
    }
}
