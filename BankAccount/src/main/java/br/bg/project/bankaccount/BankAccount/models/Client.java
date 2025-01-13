package br.bg.project.bankaccount.BankAccount.models;


import br.bg.project.bankaccount.BankAccount.dto.ClientDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {


    public Client(ClientDto dto){
        this.firstName = dto.firstname();
        this.lastName = dto.lastname();
        this.document=dto.document();
        this.email=dto.email();
        this.passWord=dto.password();
        this.amount=dto.amount();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Column(unique = true)
    private String document;

    @Column(unique = true)
    @NotBlank
    private String email;

    @NotBlank
    private String passWord;

    private BigDecimal amount;
}
