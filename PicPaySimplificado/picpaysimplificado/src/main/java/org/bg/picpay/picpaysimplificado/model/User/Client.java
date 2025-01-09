package org.bg.picpay.picpaysimplificado.model.User;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.bg.picpay.picpaysimplificado.dto.data.ClientDTO;
import org.bg.picpay.picpaysimplificado.model.User.utils.AccountType;
import org.bg.picpay.picpaysimplificado.model.User.utils.Credentials;
import org.bg.picpay.picpaysimplificado.model.address.Address;
import org.bg.picpay.picpaysimplificado.model.converter.AddressConverter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;
import static org.bg.picpay.picpaysimplificado.model.User.utils.AccountType.valueDB;

@Entity(name="Client")
@Table(name = "tb_clients")
@Setter
public class Client implements Serializable {

    public Client(ClientDTO dto, Address address, Credentials credentials) {
        this.firstName = dto.firstname();
        this.lastName = dto.lastname();
        this.balance = dto.balance();
        this.address = address;
        this.credentials = credentials;
        setAccount(valueDB(dto.clientType()));
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

    @NotNull
    @Column(name = "client_type")
    private char type;

    @Column(columnDefinition = "JSON")
    @Convert(converter = AddressConverter.class)
    @Getter(AccessLevel.NONE)
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credentials")
    private Credentials credentials;



    public AccountType getAccount() {
        return valueDB(type);
    }

    public void setAccount(AccountType code) {
        if (code != null) {
            this.type = code.getCode();
        }
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

    public Credentials getCredentials(){
        return this.credentials;
    }



}

