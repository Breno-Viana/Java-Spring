package com.emprestimo.aplicacao.emprestimo_app.tutorial;

import com.emprestimo.aplicacao.emprestimo_app.model.item.Item;
import com.emprestimo.aplicacao.emprestimo_app.model.item.qr.QrCode;
import com.emprestimo.aplicacao.emprestimo_app.model.item.repository.ItemRepository;
import com.emprestimo.aplicacao.emprestimo_app.model.item.repository.QrRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class Tutorial06test {
    @Autowired
    private QrRepository qrRepository;
    @Autowired
    private ItemRepository repository;

    private static final String ITEM_NAME = "Nokia 3210";
    private static final UUID QR_CODE = UUID.randomUUID();

    @Test
    void cascadeTypePersist() {  //utilização do CascadeType.PERSIST para criar um objento do qr code automaticamente sem a necessidade de salvar antes
        var Qr = new QrCode();
        Qr.setCode(QR_CODE);


        var item = new Item();
        item.setName(ITEM_NAME);
        item.setQr_code(Qr);
        repository.save(item);

        var item2 = repository.findById(item.getId()).orElseThrow();
        Assertions.assertEquals(item2.getQr_code().getCode(), Qr.getCode());


    }

    @Test
    void CascadeTypeMerge() { //utilização do CascadeType.MERGE para nao precisar salvar um novo qr code quando for atuaizar o item
        var ATUALIZADO_NOME = ITEM_NAME + "atualizado";
        var NOVO_QR = UUID.randomUUID();
        var Qr = new QrCode();
        Qr.setCode(QR_CODE);

        var item = new Item();
        item.setName(ITEM_NAME);
        item.setQr_code(Qr);
        repository.save(item);

        item.setName(ATUALIZADO_NOME);
        Qr.setCode(NOVO_QR);
        repository.save(item);

        var item2 = repository.findById(item.getId()).orElseThrow();
        Assertions.assertEquals(ATUALIZADO_NOME,item2.getName());
        Assertions.assertEquals(NOVO_QR,item2.getQr_code().getCode());
    }

    @Test
    void CascadeTypeRemove(){ //remove o qr code quando o item é apagado com o CascadeType.REMOVE
        var ATUALIZADO_NOME = ITEM_NAME + "atualizado";
        var NOVO_QR = UUID.randomUUID();
        var Qr = new QrCode();
        Qr.setCode(QR_CODE);

        var item = new Item();
        item.setName(ITEM_NAME);
        item.setQr_code(Qr);
        repository.save(item);

        repository.delete(item);

        Assertions.assertTrue(repository.findById(item.getId()).isEmpty());
        Assertions.assertTrue(qrRepository.findById(Qr.getId()).isEmpty());
    }
}
