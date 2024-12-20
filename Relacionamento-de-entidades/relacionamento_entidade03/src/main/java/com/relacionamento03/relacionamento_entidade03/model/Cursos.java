package com.relacionamento03.relacionamento_entidade03.model;


import jakarta.persistence.*;


import java.util.HashSet;
import java.util.Set;


@Table(name = "cursos_tb")
@Entity
public class Cursos {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long curso_id;


    @Column(name = "cursos_name")
    private String nameC;


    @ManyToMany(mappedBy = "cursos")
    Set<Alunos> alunos = new HashSet<>();

    public String getNameC() {
        return nameC;
    }

    public void setNameC(String nameC) {
        this.nameC = nameC;
    }
}
