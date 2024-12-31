package org.bg.picpay.picpaysimplificado.model.Transations;


import jakarta.persistence.*;
import org.bg.picpay.picpaysimplificado.dto.SenderAndReceiverDTO;
import org.bg.picpay.picpaysimplificado.dto.TransactionDetailsDTO;
import org.bg.picpay.picpaysimplificado.model.User.Client;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "tb_transactions")
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
    @Column(name = "transaction_id")
    private UUID id;

    @JoinColumn(name = "sender_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Client sender;


    @JoinColumn(name = "receiver_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Client receiver;

    @Column(name = "transaction_value")
    private BigDecimal value;

    @Column(name = "transaction_instant")
    private LocalDateTime instantTime;


    @PrePersist
    public void Instant() {
        instantTime = LocalDateTime.now();
    }

    public void setInstantTime(LocalDateTime instantTime) {
        this.instantTime = instantTime;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setSender(Client sender) {
        this.sender = sender;
    }

    public void setReceiver(Client receiver) {
        this.receiver = receiver;
    }

    public void setValue(BigDecimal amount) {
        this.value = amount;
    }

    public TransactionDetailsDTO getTransactionDetailsDTO() {
        return new TransactionDetailsDTO(id,  new SenderAndReceiverDTO(sender.getFirstName(), sender.getLastName(), sender.getDocument(), sender.getAccount()), new SenderAndReceiverDTO(receiver.getFirstName(), receiver.getLastName(), receiver.getDocument(), receiver.getAccount()), value, instantTime);
    }
}
