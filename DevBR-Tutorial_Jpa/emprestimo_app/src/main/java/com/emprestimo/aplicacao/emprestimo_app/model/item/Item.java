package com.emprestimo.aplicacao.emprestimo_app.model.item;

import com.emprestimo.aplicacao.emprestimo_app.model.item.qr.QrCode;
import jakarta.persistence.*;



@Table(name="tb_item")
@Entity
public class Item {


    @Column(name = "item_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="item_name",nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT",name="item_description")
    @Lob
    private String description;

    @OneToOne
   // @JoinColumn(name="qr_code",referencedColumnName = "id")
    private QrCode qr_code;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   public QrCode getQr_code() {
        return qr_code;
    }

    public void setQr_code(QrCode qr_code) {
        this.qr_code = qr_code;
    }
}
