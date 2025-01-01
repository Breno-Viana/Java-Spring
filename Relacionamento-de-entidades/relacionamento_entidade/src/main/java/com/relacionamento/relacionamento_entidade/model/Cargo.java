package com.relacionamento.relacionamento_entidade.model;



import java.util.Set;

import com.relacionamento.relacionamento_entidade.dto.CargoDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="cargos")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cargo {

    public Cargo(CargoDto dto){
        this.nome = dto.nome();
        this.salario = dto.salario();
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cargo")
    private Long id;


    @Column(name="nome_cargo",nullable = false)
    private String nome;


    @Column(name="salario_cargo",nullable = false)
    private Double salario;

}
