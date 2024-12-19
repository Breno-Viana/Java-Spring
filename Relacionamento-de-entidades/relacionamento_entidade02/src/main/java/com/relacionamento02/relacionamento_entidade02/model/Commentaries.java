package com.relacionamento02.relacionamento_entidade02.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "commentaries")
public class Commentaries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentary_id;


    @Column(name="author")
    private String author;


    @Lob
    @Column(nullable = false,columnDefinition = "TEXT")
    private String commentary;
}
