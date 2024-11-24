package br.com.apirest.ApiRestAPP.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity//"Transforma" a classe Product em uma table
public class Product {

    @Getter
    @Id//faz com que seja o id da table
    @GeneratedValue(strategy = GenerationType.AUTO)//como se fose o auto_incremant do sql
    private Integer id;

    @Getter
    @Setter
    @Column(nullable = false)
    private String name;

    @Getter
    @Setter
    @Column(nullable = false)
    private Integer price;

    @Getter
    @Setter
    @Column()
    private String description;


}
