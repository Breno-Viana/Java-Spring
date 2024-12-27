package com.emprestimo.aplicacao.emprestimo_app.tutorial;


import com.emprestimo.aplicacao.emprestimo_app.model.item.Item;
import com.emprestimo.aplicacao.emprestimo_app.model.item.repository.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Tutorial17Test {

    @Autowired
    private ItemRepository itemRepository;


    @Test
    void entidadeEmbutido(){
        var item = new Item();
        item.setName("maquina de pipoca");
        itemRepository.save(item);

        var itemDoRepositorio = itemRepository.findById(item.getId())
                        .orElseThrow();


        Assertions.assertEquals("maquina de pipoca",itemDoRepositorio.getName() );
    }
}
