 package com.relacionamento.relacionamento_entidade.model;

import java.util.UUID;

import com.relacionamento.relacionamento_entidade.dto.ColaboradorDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="colaboradores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Colaborador {

    public Colaborador(ColaboradorDto dto, Cargo cargo) {
       this.nome = dto.nome();
       this.cargo = cargo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id_colaborador")
    private UUID id;


    @Column(nullable = false,name="nome_colaborador")
    private String nome;
   
    @OneToOne
    @JoinColumn(name="cargo_colaborador",referencedColumnName = "id_cargo")
    private Cargo cargo;
}
