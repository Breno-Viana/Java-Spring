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
public class Tutorial08test {


    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    void testeComOAtQuery(){
        var pessoa = new Pessoa();
        pessoa.setName("carlos");
        pessoa.setEmail("carlos@test.com");
        pessoaRepository.save(pessoa);
        var pessoaC = pessoaRepository.buscarPorEmail("carlos@test.com").orElseThrow();
        Assertions.assertNotNull(pessoaC);
        Assertions.assertEquals("carlos@test.com",pessoaC.getEmail());
    }

    @Test
    void buscaPeloNomeDoItem(){
        var item = new Item();
        item.setName("9999 jogos em 1");
        itemRepository.save(item);

        var pessoa = new Pessoa();
        pessoa.setName("carlos");
        pessoa.setEmail("carlos@Test.com");
        pessoa.getItens().add(item);
        pessoaRepository.save(pessoa);

        var pessoaO = pessoaRepository.buscarPeloNomeDoItem("9999 jogos em 1");
        Assertions.assertNotNull(pessoaO);
        Assertions.assertEquals(pessoa.getId(), pessoaO.getFirst().getId());
    }
}
