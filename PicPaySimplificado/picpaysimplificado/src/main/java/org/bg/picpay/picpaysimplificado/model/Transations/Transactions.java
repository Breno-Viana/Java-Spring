package org.bg.picpay.picpaysimplificado.model.Transations;


import jakarta.persistence.*;
import org.bg.picpay.picpaysimplificado.dto.TransactionDto;
import org.bg.picpay.picpaysimplificado.model.User.User;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name="tb_transactions")
public class Transactions implements Serializable {


    public Transactions() {
    }

    public Transactions( User sender, User receiver, BigDecimal amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="transaction_id")
    private UUID id;

    @JoinColumn(name = "sender_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private User sender;


    @JoinColumn(name="receiver_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private User receiver;

    @Column(name = "transaction_amount")
    private BigDecimal amount;

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

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
