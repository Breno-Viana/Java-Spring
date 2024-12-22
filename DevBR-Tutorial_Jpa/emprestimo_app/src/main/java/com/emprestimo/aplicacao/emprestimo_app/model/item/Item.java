package com.emprestimo.aplicacao.emprestimo_app.model.item;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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

}
