package com.emprestimo.aplicacao.emprestimo_app.tutorial;

import com.emprestimo.aplicacao.emprestimo_app.model.item.Item;
import com.emprestimo.aplicacao.emprestimo_app.model.item.repository.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Set;

@SpringBootTest
public class Tutorial12Test {



    @Autowired
    private ItemRepository itemRepository;

    @Test
    void testeDoFetchType(){
        var item = new Item();
        item.setName("pega varetas");
        itemRepository.save(item);


        var categoriaRepository = itemRepository
                .findById(item.getId())
                .map(Item::getCategorias)
                .orElse(Set.of());


        Assertions.assertTrue(categoriaRepository.isEmpty());
    }
}
