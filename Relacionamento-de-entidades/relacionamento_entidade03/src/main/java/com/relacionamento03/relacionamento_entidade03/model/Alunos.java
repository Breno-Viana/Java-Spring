package com.relacionamento03.relacionamento_entidade03.model;


import jakarta.persistence.*;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Table(name="alunos_tb")
@Entity
public class Alunos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alunos_id;


    @Column(name = "alunos_nome",nullable = false)
    private String nome;


    @ManyToMany
    @JoinTable(
            name = "tabela_auxilio",
            joinColumns = {@JoinColumn(name="id_aluno",referencedColumnName ="alunos_id")},
            inverseJoinColumns = {@JoinColumn(name = "curso_id",referencedColumnName = "curso_id")}
    )
     private Set<Cursos> cursos = new HashSet<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<Cursos> getCursos() {
        return this.cursos;
    }
}
