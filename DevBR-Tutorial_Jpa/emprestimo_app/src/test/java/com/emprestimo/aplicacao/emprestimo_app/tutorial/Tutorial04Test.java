package com.emprestimo.aplicacao.emprestimo_app.tutorial;


import com.emprestimo.aplicacao.emprestimo_app.model.item.Item;
import com.emprestimo.aplicacao.emprestimo_app.model.item.qr.QrCode;
import com.emprestimo.aplicacao.emprestimo_app.model.item.repository.ItemRepository;
import com.emprestimo.aplicacao.emprestimo_app.model.item.repository.QrRepository;
import com.emprestimo.aplicacao.emprestimo_app.model.pessoa.Pessoa;
import com.emprestimo.aplicacao.emprestimo_app.model.pessoa.Repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class Tutorial04Test {

    private static final String ITEM_NAME = "Sony Walkman";
    private static final String ITEM_DESCRIPTION = "Sony Walkman De ultima geração";
    private static final UUID QR_CODE = UUID.randomUUID();
    private static final String NAME = "Ana";
    private static final String EMAIL = "ana@gmail.com";


    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private QrRepository qrRepository;


    @Test
    @Transactional
    void SalvarPessoaComItem(){

        var qr = new QrCode();
        qr.setCode(QR_CODE);
        qrRepository.save(qr);

        var item = new Item();
        item.setName(ITEM_NAME);
        item.setDescription(ITEM_DESCRIPTION);
        item.setQr_code(qr);
        itemRepository.save(item);

        var pessoa = new Pessoa();
        pessoa.setName(NAME);
        pessoa.setEmail(EMAIL);
        pessoa.getItens().add(item);
        pessoaRepository.save(pessoa);

        pessoaRepository.findById(pessoa.getId()).ifPresentOrElse(
                verificarPessoa ->{
                    Assertions.assertNotNull(verificarPessoa.getId());
                    Assertions.assertNotNull(verificarPessoa.getItens());
                    Assertions.assertEquals(NAME,verificarPessoa.getName());
                    Assertions.assertEquals(EMAIL,verificarPessoa.getEmail());
                    Assertions.assertEquals(1, verificarPessoa.getItens().size());

                    verificarPessoa.getItens().stream().findFirst().ifPresent(item1 -> {
                        Assertions.assertEquals(item1,item  );
                    });
                },()->Assertions.fail("empty body")
        );


    }
}
