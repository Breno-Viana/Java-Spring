package br.com.training.trainingapp.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import br.com.training.trainingapp.dto.RegisterDto;
import br.com.training.trainingapp.utils.UserSituation;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "registers_tb")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Registers {

    public Registers(RegisterDto registerDto){
        this.userName = registerDto.nome();
        this.identifier = registerDto.identificador();
        this.email = registerDto.Email();
        this.userSituation = registerDto.situacao();
    }

    @Id

    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    @NotBlank(message = "Nao deixe esse campo em branco")

    private String userName;

    @Column(columnDefinition = "TEXT",nullable = false)
    @NotBlank(message = "nao deixe esse campo em branco")

    @Min(11)
    @Lob
    private String identifier;

    @Column(nullable = false,name = "user_email")
    @Email(message = "digite um email valido")
    private String email;

    @Column(name="creation_date")
    private LocalDate creationDate;

    @Column(name="update_date")
    private LocalDate updateDate;

    @Column(name="creation_hour")
    private LocalTime creationTime;

    @Column(name="update_hour")
    private LocalTime updateTime;


    @Column(nullable = false,name="user_situation")
    @Enumerated(EnumType.STRING)
    UserSituation userSituation;

    @PrePersist
    public void whenCreated() {
        this.creationDate = LocalDate.now();
        this.updateDate = LocalDate.now();
        this.creationTime = LocalTime.now();
        this.updateTime = LocalTime.now();
    }

    @PreUpdate
    public void whenEdit() {
        this.updateDate = LocalDate.now();
        this.updateTime = LocalTime.now();

    }


}