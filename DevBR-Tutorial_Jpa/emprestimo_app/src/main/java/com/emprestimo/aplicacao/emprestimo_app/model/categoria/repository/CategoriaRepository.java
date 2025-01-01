package com.emprestimo.aplicacao.emprestimo_app.model.categoria.repository;

import com.emprestimo.aplicacao.emprestimo_app.model.categoria.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,String> {
}
