package com.emprestimo.aplicacao.emprestimo_app.model.item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Table(name="tb_item")
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

}
