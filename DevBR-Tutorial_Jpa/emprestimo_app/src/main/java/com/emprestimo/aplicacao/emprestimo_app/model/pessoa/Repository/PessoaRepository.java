package com.emprestimo.aplicacao.emprestimo_app.model.pessoa.Repository;

import com.emprestimo.aplicacao.emprestimo_app.model.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa,Integer> {
}
