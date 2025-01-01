package com.relacionamento02.relacionamento_entidade02.controller;


import com.relacionamento02.relacionamento_entidade02.dto.PostDto;
import com.relacionamento02.relacionamento_entidade02.model.Commentaries;
import com.relacionamento02.relacionamento_entidade02.model.Posts;
import com.relacionamento02.relacionamento_entidade02.repository.CommentaryRepository;
import com.relacionamento02.relacionamento_entidade02.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/postar")
public class PostsController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentaryRepository commentaryRepository;


    @GetMapping("/listar")
    public List<Posts> listarPost(){
        return postRepository.findAll();
    }

    @PostMapping("/adicionar")
    public ResponseEntity<Posts> postar(@RequestBody PostDto postDto){
        Set<Commentaries> comments = new HashSet<>();
        for (Long id_comment : postDto.comentarios()){
            Optional<Commentaries> comment = commentaryRepository.findById(id_comment);
            comment.ifPresent(comments::add);
        }
        Posts post = new Posts(postDto,comments);

        postRepository.save(post);

        return new ResponseEntity<Posts>(HttpStatus.CREATED);
    }

}
