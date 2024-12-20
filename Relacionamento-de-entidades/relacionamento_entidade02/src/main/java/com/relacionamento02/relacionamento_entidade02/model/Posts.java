package com.relacionamento02.relacionamento_entidade02.model;


import com.relacionamento02.relacionamento_entidade02.dto.PostDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name="user_posts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Posts {

    public Posts(PostDto dto, Set<Commentaries> commentary){
        title = dto.titulo();
        text = dto.conteudo();
        this.commentaries = commentary;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_id;


    @Column(name = "post_title")
    private String title;


    @Lob
    @Column(columnDefinition = "TEXT",name = "post_content")
    private String text;

    @OneToMany
    @JoinColumn(name = "post_id")
    private Set<Commentaries> commentaries;// = new HashSet<>();

}
