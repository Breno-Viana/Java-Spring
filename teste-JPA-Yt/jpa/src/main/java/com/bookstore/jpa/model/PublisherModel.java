package com.bookstore.jpa.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="TB_PUBLISHER")
@NoArgsConstructor
@Getter
@Setter
public class PublisherModel implements Serializable {
    private static final long serialVersionId = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    @NotBlank
    @Column(nullable = false, unique = true, name = "Publisher_Name")
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "publisher",fetch = FetchType.LAZY)
    private Set<BookModel> books = new HashSet<>();

}
