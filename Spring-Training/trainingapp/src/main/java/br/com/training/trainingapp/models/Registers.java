package br.com.training.trainingapp.models;

import java.time.LocalDate;
import java.time.LocalTime;
import br.com.training.trainingapp.utils.UserSituation;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
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
    @Min(11)
    private String identifier;

    @Column(nullable = false)
    @Email(message = "digite um email valido")
    @Getter
    @Setter
    private String email;

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

    @Getter
    @Setter
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    UserSituation userSituation = UserSituation.PENDENTE;

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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getE_mail() {
        return email;
    }

    public void setE_mail(String e_mail) {
        this.email = e_mail;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public LocalTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalTime creationTime) {
        this.creationTime = creationTime;
    }

    public LocalTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalTime updateTime) {
        this.updateTime = updateTime;
    }

    public UserSituation getUserSituation() {
        return userSituation;
    }

    public void setUserSituation(UserSituation userSituation) {
        this.userSituation = userSituation;
    }
}