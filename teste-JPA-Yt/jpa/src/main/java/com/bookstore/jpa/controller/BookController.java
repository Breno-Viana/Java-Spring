package com.bookstore.jpa.controller;

import com.bookstore.jpa.dto.BooKRecordDTO;
import com.bookstore.jpa.model.BookModel;
import com.bookstore.jpa.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookstore/books")
public class BookController {

    public final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
     @PostMapping
    public ResponseEntity<BookModel> saveBook(@RequestBody BooKRecordDTO booKRecordDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBook(booKRecordDTO));
     }
}
