package br.bg.project.bankaccount.BankAccount.models;


import br.bg.project.bankaccount.BankAccount.dto.response.Receiver;
import br.bg.project.bankaccount.BankAccount.dto.response.Sender;
import br.bg.project.bankaccount.BankAccount.dto.response.TransactionResponse;
import br.bg.project.bankaccount.BankAccount.infra.exceptions.errors.ClientNotFoundException;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Table(name = "tb_transactions")
public class Transactions {
    public Transactions() {
    }

    public Transactions(BigDecimal value, Client receiver, Client sender) {
        this.value = value;
        this.receiver = Set.of(receiver);
        this.sender = Set.of(sender);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;


    @ManyToMany
    @JoinTable(
            name = "senders",
            joinColumns = @JoinColumn(name = "transaction"),
            inverseJoinColumns = @JoinColumn(name = "sender_id")
    )
    private Set<Client> sender;


    @ManyToMany
    @JoinTable(
            name = "receivers",
            joinColumns = @JoinColumn(name = "transaction"),
            inverseJoinColumns = @JoinColumn(name = "receiver_id")
    )
    private Set<Client> receiver;


    @NotNull
    private BigDecimal value;

    @Column(name = "date_and_time")
    private LocalDateTime dateTime;


    @PrePersist
    public void setDateTime(){
        this.dateTime=LocalDateTime.now();
    }





    public TransactionResponse getTRANSACTION(){
        var s = sender.stream().findFirst().orElseThrow(ClientNotFoundException::new);
        var r = receiver.stream().findFirst().orElseThrow(ClientNotFoundException::new);
        var sender = new Sender(s.getFirstName()+" "+s.getLastName(),s.getDocument());
        var receiver = new Receiver(r.getFirstName()+" "+r.getLastName(),r.getDocument());
        return new TransactionResponse(sender,receiver,value,dateTime);
    }
}
