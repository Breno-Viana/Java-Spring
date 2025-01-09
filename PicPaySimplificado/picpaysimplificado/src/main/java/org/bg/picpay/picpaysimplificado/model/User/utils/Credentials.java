package org.bg.picpay.picpaysimplificado.model.User.utils;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.bg.picpay.picpaysimplificado.dto.data.ClientDTO;
import org.bg.picpay.picpaysimplificado.dto.utils.AdminDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.management.relation.RoleNotFoundException;


@Setter
@Getter
@Entity(name="Credentials")
@Table(name="tb_credentials")
@EqualsAndHashCode(of = "document")
public class Credentials {


    public Credentials() {
    }


    public Credentials(AdminDTO dto) throws RoleNotFoundException {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.email=dto.email();
        this.document=dto.document();
       this.password= encoder.encode(dto.password());
       this.role=Roles.valuesRole(dto.codeRole());
    }

    public Credentials(ClientDTO dto){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.email=dto.email();
        this.password=encoder.encode(dto.password());
       this.document=dto.document();
    }


    @Email
    @NotNull
    @NotBlank
    @Column(name="email",unique = true)
    private String email;


    @Id
    @Column(name="client_document")
    private String document;


    @NotNull
    @NotBlank
    @Column(name="pass_word")
    private String password;

    @Enumerated(EnumType.STRING)
    private Roles role;


    public boolean isCorrectPassWord(String password, BCryptPasswordEncoder enc){
        return enc.matches(password,this.password);
    }

    public void setRole(Integer integer) throws RoleNotFoundException {
        this.role=Roles.valuesRole(integer);
    }



}
