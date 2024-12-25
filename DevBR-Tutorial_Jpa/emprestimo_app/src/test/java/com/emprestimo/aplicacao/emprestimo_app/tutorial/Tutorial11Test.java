package com.emprestimo.aplicacao.emprestimo_app.tutorial;


import com.emprestimo.aplicacao.emprestimo_app.model.item.Item;
import com.emprestimo.aplicacao.emprestimo_app.model.item.repository.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import static java.util.stream.IntStream.rangeClosed;

@SpringBootTest
public class Tutorial11Test {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    void ordenarPorParametro(){
        rangeClosed(0,2).forEach(i ->{
            var item = new Item();
            item.setName("item "+i);
            itemRepository.save(item);
        });


        var sort = Sort.by(Sort.Direction.DESC,"name","id");
        var itens = itemRepository.findAll(sort);

        Assertions.assertEquals("item 2",itens.getFirst().getName());
        Assertions.assertEquals("item 0",itens.getLast().getName());

    }
}
