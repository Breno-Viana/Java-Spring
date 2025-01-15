package br.bg.project.bankaccount.BankAccount.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_login")
public class Login {

    public Login(){

    }

    public Login( String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    private String login;
    private String password;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
