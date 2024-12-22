package com.emprestimo.aplicacao.emprestimo_app.model.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emprestimo.aplicacao.emprestimo_app.model.item.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    
}
