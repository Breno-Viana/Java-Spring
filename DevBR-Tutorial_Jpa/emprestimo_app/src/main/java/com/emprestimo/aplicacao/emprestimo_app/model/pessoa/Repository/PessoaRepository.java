package com.emprestimo.aplicacao.emprestimo_app.model.pessoa.Repository;

import com.emprestimo.aplicacao.emprestimo_app.model.item.Item;
import com.emprestimo.aplicacao.emprestimo_app.model.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Integer> {

    Optional<Pessoa> findByEmail(String email);

    List<Pessoa> findByItens_name(String nome);
}
