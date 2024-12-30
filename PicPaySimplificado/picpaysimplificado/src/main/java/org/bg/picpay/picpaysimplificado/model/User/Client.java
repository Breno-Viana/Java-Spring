package org.bg.picpay.picpaysimplificado.model.User;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.bg.picpay.picpaysimplificado.dto.ClientDTO;
import org.bg.picpay.picpaysimplificado.model.User.utils.AccountType;

import org.bg.picpay.picpaysimplificado.model.address.Address;
import org.bg.picpay.picpaysimplificado.model.address.converter.AddressConverter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import static org.bg.picpay.picpaysimplificado.model.User.utils.AccountType.valueDB;

@Entity
@Table(name = "tb_clients")
public class Client implements Serializable {

    public Client(ClientDTO dto, Address address) {
        this.firstName = dto.firstName();
        this.lastName = dto.lastName();
        this.document = dto.document();
        this.balance = dto.balance();
        this.address = address;

    }

    public Client() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "client_id")
    private UUID id;

    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "cl_client_balance")
    private BigDecimal balance;

    @NotBlank
    @Column(unique = true, name = "cl_document")
    private String document;

    @NotNull
    @Column(name = "client_type")
    private char type;

    @Column(columnDefinition = "JSON")
    @Convert(converter = AddressConverter.class)
    private Address address;

    @Email
    private String email;
    @Column(name="pass")
    private String Senha;


    public AccountType getAccount() {
        return valueDB(type);
    }

    public void setAccount(AccountType code) {
        if (code != null) {
            this.type = code.getCode();
        }
    }


    public String getDocument() {
        return document;
    }

    public String getFirstName() {
        return firstName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public UUID getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress(){
        return this.address;
    }

    public void setAddress(Address address){
        this.address=address;
    }
}

