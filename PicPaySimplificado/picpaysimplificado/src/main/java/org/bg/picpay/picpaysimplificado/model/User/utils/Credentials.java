package org.bg.picpay.picpaysimplificado.model.User.utils;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.bg.picpay.picpaysimplificado.dto.data.ClientDTO;
import org.bg.picpay.picpaysimplificado.dto.utils.AdminDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="tb_credentials")
public class Credentials implements UserDetails {


    public Credentials() {
    }


    public Credentials(AdminDTO dto){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.email=dto.email();
        this.document=dto.document();
        this.password= encoder.encode(dto.password());
        this.role=dto.role();
    }

    public Credentials(ClientDTO dto){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.email=dto.email();
        this.password=encoder.encode(dto.passWord());
        this.document=dto.document();
        this.role=dto.role();
    }

    @Id
    @Column(name="login_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Email
    @NotNull
    @NotBlank
    @Column(name="email",unique = true)
    private String email;


    @NotBlank
    @Column(name="client_document")
    private String document;


    @NotNull
    @NotBlank
    @Column(name="pass_word")
    private String password;


    @Enumerated(EnumType.STRING)
    private ClientRoles role;

   /* public UUID getId() {
        return id;
    }*/

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ClientRoles getRole() {
        return role;
    }

    public void setRole(ClientRoles role) {
        this.role = role;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public boolean isCorrectPassWord(String password){
        BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
        return enc.matches(password,this.password);
    }
}
