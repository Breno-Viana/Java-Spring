package com.bookstore.jpa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;


@Getter
@Entity
@Table(name = "TB_REVIEW")
@NoArgsConstructor

public class ReviewModel implements Serializable {
    private static final long serialVersionId = 1L;

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;



    @NotBlank
    @Column(nullable = false, unique = true,name = "Commentaries",columnDefinition = "TEXT")
    @Lob
    private String commentary;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne
    @JoinColumn(name = "book_id")
    private BookModel book;

}
