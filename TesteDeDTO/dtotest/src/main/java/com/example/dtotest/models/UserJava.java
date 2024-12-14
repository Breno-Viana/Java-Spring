package com.example.dtotest.models;

import com.example.dtotest.dto.UserDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Table(name ="User_Data_Test")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UserJava{



    public UserJava(UserDto userDto){
        this.Nome = userDto.Nome();
        this.Email = userDto.Email();
        this.Idade = userDto.idade();
    }


    @Id
    @Column(name = "user_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(name = "Nome_Do_Usuario")
    @NotBlank
    @Getter
    @Setter
    private String Nome;

    @Column(name = "Idade_do_Usuario")
    @NotNull
    @Getter
    @Setter
    private Integer Idade;

    @Column(name ="E_mail")
    @NotBlank
    @Getter
    @Setter
    private String Email; 


}