package com.emprestimo.aplicacao.emprestimo_app.tutorial;

import com.emprestimo.aplicacao.emprestimo_app.model.item.Item;
import com.emprestimo.aplicacao.emprestimo_app.model.item.repository.ItemRepository;
import com.emprestimo.aplicacao.emprestimo_app.model.pessoa.Pessoa;
import com.emprestimo.aplicacao.emprestimo_app.model.pessoa.Repository.PessoaRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Tutorial09Test {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    void buscarPessoaPorEmail(){
        var pessoa = new Pessoa();
        pessoa.setEmail("carlos@test.com");
        pessoa.setName("carlos");

        pessoaRepository.save(pessoa);

        var cb = em.getCriteriaBuilder();
        var q = cb.createQuery(Pessoa.class);
        var p = q.from(Pessoa.class);

        var equalEmail = cb.equal(p.get("email"),"carlos@test.com");

       var selectPessoaPorEmail = q.where(equalEmail).select(p);
       var pessoaBusca = em.createQuery(selectPessoaPorEmail)
               .getSingleResult();

        Assertions.assertEquals(pessoaBusca.getEmail(),pessoa.getEmail());

    }


    @Test
    void buscarPessoaPeloNomeDoItem(){
        var item = new Item();
        item.setName("pogobol");
        itemRepository.save(item);
        var pessoa = new Pessoa();
        pessoa.setEmail("carlos@test.com");
        pessoa.setName("carlos");
        pessoa.getItens().add(item);
        pessoaRepository.save(pessoa);

        var cb = em.getCriteriaBuilder();
        var q = cb.createQuery(Pessoa.class);
        var p = q.from(Pessoa.class);

        var i = p.join("itens");
        var equalItenName = cb.equal(i.get("name"),"pogobol");
        var selectPessoaPeloNomeDoIten = q.where(equalItenName).select(p);
       var pessoaBusca =  em.createQuery(selectPessoaPeloNomeDoIten).getResultList();

       Assertions.assertEquals(1,pessoaBusca.size());
       Assertions.assertEquals(pessoa.getId(),pessoaBusca.getFirst().getId());
    }
}
