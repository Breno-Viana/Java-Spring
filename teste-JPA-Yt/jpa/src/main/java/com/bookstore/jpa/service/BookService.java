package com.bookstore.jpa.service;

import com.bookstore.jpa.dto.BooKRecordDTO;
import com.bookstore.jpa.model.BookModel;
import com.bookstore.jpa.model.ReviewModel;
import com.bookstore.jpa.repository.AuthorRepository;
import com.bookstore.jpa.repository.BookRepository;
import com.bookstore.jpa.repository.PublisherRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class BookService {


    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Transactional
    public BookModel saveBook(BooKRecordDTO booKRecordDTO){
        BookModel book = new BookModel();
        book.setTitle(booKRecordDTO.title());
        if (publisherRepository.findById(booKRecordDTO.publisherId()).isEmpty()){
            return null;
        }
        book.setPublisher(publisherRepository.findById(booKRecordDTO.publisherId()).get());
        book.setAuthors(authorRepository.findAllById(booKRecordDTO.authorId()).stream().collect(Collectors.toSet()));

        ReviewModel review = new ReviewModel();
        review.setCommentary(booKRecordDTO.reviewComment());
        review.setBook(book);
        book.setReview(review);

        return bookRepository.save(book);
    }
}
