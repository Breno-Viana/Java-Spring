package org.bg.picpay.picpaysimplificado.model.Transations;


import jakarta.persistence.*;
import org.bg.picpay.picpaysimplificado.model.User.Client;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name="tb_transactions")
public class Transactions implements Serializable {


    public Transactions() {
    }

    public Transactions(Client sender, Client receiver, BigDecimal amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.value = amount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="transaction_id")
    private UUID id;

    @JoinColumn(name = "sender_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Client sender;


    @JoinColumn(name="receiver_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Client receiver;

    @Column(name = "transaction_value")
    private BigDecimal value;

    @Column(name="transaction_instant")
    private LocalDateTime instantTime;



    @PrePersist
    public void Instant(){
        instantTime = LocalDateTime.now();
    }

    public LocalDateTime getInstantTime() {
        return instantTime;
    }

    public void setInstantTime(LocalDateTime instantTime) {
        this.instantTime = instantTime;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Client getSender() {
        return sender;
    }

    public void setSender(Client sender) {
        this.sender = sender;
    }

    public Client getReceiver() {
        return receiver;
    }

    public void setReceiver(Client receiver) {
        this.receiver = receiver;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal amount) {
        this.value = amount;
    }
}
