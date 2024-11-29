package br.com.training.trainingapp.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Registers {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Nao deixe esse campo em branco")
    @Getter
    @Setter
    private String userName;

    @Column(nullable = false)
    @NotBlank(message = "nao deixe esse campo em branco")
    @Getter
    @Setter
    private String identifier;

    @Column(nullable = false)
    @Email(message = "digite um email valido")
    @Getter
    @Setter
    private String e_mail;

    @Getter
    @Setter
    private LocalDate creationDate;

    @Getter
    @Setter
    private LocalDate updateDate;

    @Getter
    @Setter
    private LocalTime creationTime;

    @Getter
    @Setter
    private LocalTime updateTime;

    @PrePersist
    public void whenCreated() {
        this.creationDate = LocalDate.now();
        this.updateDate = LocalDate.now();
        this.creationTime = LocalTime.now();
        this.updateTime = LocalTime.now();
    }

    @PreUpdate
    public void whenEdit() {
        updateDate = null;
        updateTime = null;
        this.updateDate = LocalDate.now();
        this.updateTime = LocalTime.now();

    }
}