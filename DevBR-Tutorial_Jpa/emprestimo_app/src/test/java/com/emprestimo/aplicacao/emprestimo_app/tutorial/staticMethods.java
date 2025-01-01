package com.emprestimo.aplicacao.emprestimo_app.tutorial;

import com.emprestimo.aplicacao.emprestimo_app.model.categoria.Categoria;
import com.emprestimo.aplicacao.emprestimo_app.model.categoria.repository.CategoriaRepository;
import com.emprestimo.aplicacao.emprestimo_app.model.item.Item;
import com.emprestimo.aplicacao.emprestimo_app.model.item.repository.ItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

public class staticMethods {


    @Transactional
    public static void salvarItemComNomeECategoria(String nomeItem, String nomeCategoria){
        var categoria = new Categoria(nomeCategoria);
        categoriaRepository.save(categoria);

        var item = new Item();
        item.setName(nomeItem);
        itemRepository.save(item);

    }


    @Autowired
    private static ItemRepository itemRepository;
    @Autowired
    private static CategoriaRepository categoriaRepository;
}
