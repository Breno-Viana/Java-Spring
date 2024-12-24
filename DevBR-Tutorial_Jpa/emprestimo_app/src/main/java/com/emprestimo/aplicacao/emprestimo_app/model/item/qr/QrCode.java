package com.emprestimo.aplicacao.emprestimo_app.model.item.qr;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="item_Qr_code")
public class QrCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name="qr_code")
    private UUID code;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UUID getCode() {
        return code;
    }

    public void setCode(UUID code) {
        this.code = code;
    }
}
