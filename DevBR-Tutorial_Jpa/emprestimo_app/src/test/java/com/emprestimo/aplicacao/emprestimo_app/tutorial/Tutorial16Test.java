package com.emprestimo.aplicacao.emprestimo_app.tutorial;

import com.emprestimo.aplicacao.emprestimo_app.model.item.Detalhes;
import com.emprestimo.aplicacao.emprestimo_app.model.item.Item;
import com.emprestimo.aplicacao.emprestimo_app.model.item.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class Tutorial16Test {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    @Transactional
    void JsonNoBancoDeDados(){

        var item = new Item();
        item.setName("vai e vem");
       item.setDetalhes(new Detalhes("garrafa pet","codigo para aumento de objeto"));
        itemRepository.save(item);

        var itemDoRepositorio = itemRepository.findById(item.getId()).orElseThrow();

        System.out.println(itemDoRepositorio.toString());
    }
}
