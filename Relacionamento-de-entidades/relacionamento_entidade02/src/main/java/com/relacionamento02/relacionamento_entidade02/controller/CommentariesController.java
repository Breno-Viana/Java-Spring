package com.relacionamento02.relacionamento_entidade02.controller;


import com.relacionamento02.relacionamento_entidade02.dto.CommentaryDto;
import com.relacionamento02.relacionamento_entidade02.model.Commentaries;
import com.relacionamento02.relacionamento_entidade02.repository.CommentaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentar")
public class CommentariesController {


    @Autowired
    private CommentaryRepository commentaryRepository;

    @GetMapping("/listar")
    public List<Commentaries> listar(){
        return commentaryRepository.findAll();
    }


    @PostMapping("/adicionar")
    public Commentaries comment(@RequestBody CommentaryDto dtoComment){
        Commentaries commentary = new Commentaries(dtoComment);
        return commentaryRepository.save(commentary);
    }



}
