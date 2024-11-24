package br.com.apirest.ApiRestAPP.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "O campo nome é obrigatorio")
    private String name;

    @Getter
    @Setter
    @Min(value = 10,message = "O campo preço é obrigatorio e o valor tem que ser igual ou superio a 10")
    @Column(nullable = false)
    private Integer price;

    @Getter
    @Setter
    @Column()
    private String description;

    //@Email
    //@CPF
    //CNPJ


}
