package br.bg.project.bankaccount.BankAccount.models;

import br.bg.project.bankaccount.BankAccount.models.enums.Roles;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_login")
public class Login implements UserDetails {

    public Login(){

    }

    public Login( String login, String password, Roles role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    private String login;
    private String password;
    @Enumerated(EnumType.STRING)
    private Roles role;

    public Login(Login login) {
        this.id = login.getId();
        this.login = login.getLogin();
        this.password = login.getPassword();
        this.role=login.getRole();
    }

    public Roles getRole() {
        return  role;
    }

    private String getLogin() {
        return login;
    }


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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role==Roles.ADMIN) return List.of(new SimpleGrantedAuthority(Roles.ADMIN.getRole()),new SimpleGrantedAuthority(Roles.BASIC.getRole()));
        else return List.of(new SimpleGrantedAuthority(Roles.BASIC.getRole()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }


    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Login login = (Login) o;
        return Objects.equals(id, login.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
