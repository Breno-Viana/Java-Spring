package com.bookstore.jpa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;


@Entity
@Table(name = "TB_REVIEW")
@NoArgsConstructor
@Getter
@Setter
public class ReviewModel implements Serializable {
    private static final long serialVersionId = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;



    @NotBlank
    @Column(nullable = false, unique = true,name = "Commentaries")
    private String commentary;

}
