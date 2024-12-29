package org.bg.picpay.picpaysimplificado.model.User;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.bg.picpay.picpaysimplificado.dto.ClientDTO;
import org.bg.picpay.picpaysimplificado.model.address.Address;
import org.bg.picpay.picpaysimplificado.model.converter.AddresConverter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import static org.bg.picpay.picpaysimplificado.model.User.AccountType.valueDB;

@Entity
@Table(name="tb_clients")
public class Client implements Serializable {

    public Client(ClientDTO dto, Address address){
        this.firstName = dto.firstName();
        this.lastName= dto.lastName();
        this.document=dto.document();
        this.email=dto.email();
        this.passWord=dto.passWord();
        this.balance=dto.balance();
        setAccount(AccountType.valueDB(dto.clientType()));
        this.address=address;


    }
    public Client(){}

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="cl_client_id")
    private UUID id;

    @NotBlank
    @Column(name="first_name")
    private String firstName;

    @NotBlank
    @Column(name="last_name")
    private String lastName;

    @Column(name="cl_client_balance")
    private BigDecimal balance;

    @NotBlank
    @Column(unique = true,name = "cl_document")
    private String document;

    @NotBlank
    @Column(name = "cl_email",unique = true)
    @Email
    private String email;

    @NotBlank
    @Column(name = "cl_pass")
    private String passWord;

    @NotNull
    @Column(name="client_type")
    private char type;

    @Column(columnDefinition = "JSON")
    @Convert(converter = AddresConverter.class)
    private Address address;




    public AccountType getAccount(){
        return valueDB(type);
    }

    public void setAccount(AccountType code){
        if (code!= null){
            this.type=code.getCode();
        }
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", balance=" + balance +
                ", document='" + document + '\'' +
                ", email='" + email + '\'' +
                ", passWord='" + passWord + '\'' +
                ", type=" + type +
                ", address=" + address +
                '}';
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress(){
        return address;
    }

    public void setAddress(Address address){
        this.address=address;
    }
}
