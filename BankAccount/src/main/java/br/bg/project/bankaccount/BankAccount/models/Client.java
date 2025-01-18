package br.bg.project.bankaccount.BankAccount.models;


import br.bg.project.bankaccount.BankAccount.dto.ClientDto;
import br.bg.project.bankaccount.BankAccount.models.enums.ClientType;
import br.bg.project.bankaccount.BankAccount.models.enums.Roles;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigDecimal;
import java.util.UUID;

import static br.bg.project.bankaccount.BankAccount.models.enums.ClientType.getTypeOfCode;

@Entity
@Table(name = "tb_client")
public class Client {


    public Client(ClientDto dto,Login login) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.firstName = dto.firstname();
        this.lastName = dto.lastname();
        this.document = dto.document();
        this.email = dto.email();
        this.passWord = passwordEncoder.encode(dto.password());
        this.amount = dto.amount();
        setType(dto.clientType());
        this.login = login;
    }

    public Client() {
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

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "cl_login")
    private Login login;

    @Column(unique = true)
    @NotBlank
    private String email;

    @NotBlank
    private String passWord;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ClientType type;



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocument() {
        return document;
    }


    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public void setDocument(String document) {
        this.document = document;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public ClientType getType() {
        return type;
    }

    public void setType(Character code) throws Exception {
        type = getTypeOfCode(code);
    }
}
