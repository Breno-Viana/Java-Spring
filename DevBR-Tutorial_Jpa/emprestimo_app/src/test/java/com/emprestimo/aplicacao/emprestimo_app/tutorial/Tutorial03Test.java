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
public class Tutorial03Test {


    @Autowired
    private ItemRepository repository;
    @Autowired
    private QrRepository qrRepository;

    private static final String ITEM_NAME = "Nokia 3210";
    private static final UUID QR_CODE = UUID.randomUUID();

    @Test
    void salvarItemComQrCode() {
        var item = new Item();
        item.setName(ITEM_NAME);


        var Qr = new QrCode();
        Qr.setCode(QR_CODE);
       // qrRepository.save(Qr);

        item.setQr_code(Qr);

        repository.save(item);
        repository.findById(item.getId()).
                ifPresentOrElse(itemVerificacao->{
                    Assertions.assertNotNull(itemVerificacao.getQr_code());
                    Assertions.assertEquals(QR_CODE,itemVerificacao.getQr_code().getCode());
                },()->Assertions.fail("empty body"));


    }
}
