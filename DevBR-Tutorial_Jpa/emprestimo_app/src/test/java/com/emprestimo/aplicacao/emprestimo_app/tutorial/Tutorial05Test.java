package com.emprestimo.aplicacao.emprestimo_app.tutorial;

import com.emprestimo.aplicacao.emprestimo_app.model.categoria.Categoria;
import com.emprestimo.aplicacao.emprestimo_app.model.categoria.repository.CategoriaRepository;
import com.emprestimo.aplicacao.emprestimo_app.model.item.Item;
import com.emprestimo.aplicacao.emprestimo_app.model.item.repository.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class Tutorial05Test {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ItemRepository itemRepository;


    @Test
    @org.springframework.transaction.annotation.Transactional
    void SalvarItemComCategoria() {
        String CATEGORIA = "Equipamento Eletronico";
        var categoria = new Categoria(CATEGORIA);
        categoriaRepository.save(categoria);

        var item = new Item();
        String ITEM_NOME = "Tocador de fita VHS";
        item.setName(ITEM_NOME);
        item.getCategorias().add(categoria);
        itemRepository.save(item);

        var test = itemRepository.findById(item.getId());

        test.ifPresentOrElse(item1 -> {
            var verificar = item1.getCategorias().stream().findFirst().orElseThrow();
            assertEquals(categoria.getCategoria(), verificar.getCategoria());
        }, Assertions::fail);


    }
}
