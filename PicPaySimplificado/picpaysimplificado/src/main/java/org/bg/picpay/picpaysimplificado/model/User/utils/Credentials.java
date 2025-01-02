package org.bg.picpay.picpaysimplificado.model.User.utils;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.bg.picpay.picpaysimplificado.dto.data.ClientDTO;
import org.bg.picpay.picpaysimplificado.infra.security.admin.AdminDTO;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

@Entity
@Table(name="tb_credentials")
public class Credentials {
    public Credentials() {
    }


    public Credentials(AdminDTO dto){
        this.email=dto.email();
        this.document=dto.document();
        this.password=dto.password();
        this.role=dto.role();
    }

    public Credentials(ClientDTO dto){
        this.email=dto.email();
        this.password=dto.passWord();
        this.document=dto.document();
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ClientRoles getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = ClientRoles.valueOf(role);
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
