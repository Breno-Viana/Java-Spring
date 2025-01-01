package com.br.security_project.ProjectSecurity.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;


@Entity
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn
    private User userId;


    private String content;


    @CreationTimestamp
    private Instant creationTimeInstant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getCreationTimeInstant() {
        return creationTimeInstant;
    }

    public void setCreationTimeInstant(Instant creationTimeInstant) {
        this.creationTimeInstant = creationTimeInstant;
    }
}
