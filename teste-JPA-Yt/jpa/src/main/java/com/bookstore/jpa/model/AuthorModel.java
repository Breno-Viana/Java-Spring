package com.bookstore.jpa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;


@NoArgsConstructor
@Entity
@Table(name = "TB_AUTHOR")
@Getter
@Setter
public class AuthorModel implements Serializable {
    private static final long serialVersionId = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    @NotBlank
    @Column(nullable = false, unique = true,name = "Author_Name")
    private String name;


}

