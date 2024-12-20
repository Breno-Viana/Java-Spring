package com.relacionamento02.relacionamento_entidade02.model;


import com.relacionamento02.relacionamento_entidade02.dto.CommentaryDto;
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

    public Commentaries(CommentaryDto dto){
        this.author = dto.autor();
        this.commentary = dto.comentario();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentary_id;


    @Column(name="author")
    private String author;


    @Lob
    @Column(nullable = false,columnDefinition = "TEXT")
    private String commentary;
}
