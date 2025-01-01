package com.emprestimo.aplicacao.emprestimo_app.tutorial;

import com.emprestimo.aplicacao.emprestimo_app.model.item.Item;
import com.emprestimo.aplicacao.emprestimo_app.model.item.repository.ItemRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Tutorial02Test {

    private static final String ITEM_NAME = "impressora";
    private static final String ITEM_DESCRIPTION = "Epson LX300";

 
    @Autowired
    private ItemRepository repository;


    @Test
    void CriarItemTeste() {
        var item = new Item();
        item.setName(ITEM_NAME);
        item.setDescription(ITEM_DESCRIPTION);
       var itemRepositorio = repository.save(item);
       assertNotNull(itemRepositorio.getId());

    }



    @Test
    void atualizarItemTest(){
        var item_atualizado = ITEM_NAME + "atualizado";
        var item = new Item();
        item.setName(ITEM_NAME);
        item.setDescription(ITEM_DESCRIPTION);
        repository.save(item);


        repository.findById(item.getId()).ifPresent(
            itemParaAtualizar -> {
                itemParaAtualizar.setName(item_atualizado);
                repository.save(itemParaAtualizar);
            }
        );

        repository.findById(item.getId()).ifPresentOrElse(
            itemParaVerificar ->{
                assertEquals(item_atualizado, itemParaVerificar.getName());
            },
            () -> Assertions.fail(() -> "empty object")
        );



    }
}
