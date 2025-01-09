package org.bg.picpay.picpaysimplificado.model.Transations;


import jakarta.persistence.*;
import lombok.Setter;
import org.bg.picpay.picpaysimplificado.dto.utils.SenderAndReceiverDTO;
import org.bg.picpay.picpaysimplificado.dto.utils.TransactionDetailsDTO;
import org.bg.picpay.picpaysimplificado.model.User.Client;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@Setter
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

    public TransactionDetailsDTO getTransactionDetails() {
        return new TransactionDetailsDTO(id,  new SenderAndReceiverDTO(sender.getFirstName(), sender.getLastName(), sender.getAccount()), new SenderAndReceiverDTO(receiver.getFirstName(), receiver.getLastName(), receiver.getAccount()), value, instantTime);
    }
}
