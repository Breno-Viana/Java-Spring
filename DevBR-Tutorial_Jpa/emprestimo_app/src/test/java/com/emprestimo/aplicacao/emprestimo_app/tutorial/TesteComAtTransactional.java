package com.emprestimo.aplicacao.emprestimo_app.tutorial;



import com.emprestimo.aplicacao.emprestimo_app.model.categoria.repository.CategoriaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TesteComAtTransactional {

    @Autowired
    private  CategoriaRepository categoriaRepository;

    @Test
    void rollbackException(){
        try{
            staticMethods.salvarItemComNomeECategoria(null,"brinquedos");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        var categas = categoriaRepository.findById("brinquedos");
        Assertions.assertTrue(categas.isEmpty());
    }









}
