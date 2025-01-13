package br.bg.project.bankaccount.BankAccount.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Entity
@Table(name = "tb_transactions")
@NoArgsConstructor
@AllArgsConstructor
public class Transactions {


    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;


    @JoinColumn(name="sender_id")
    @OneToOne
    private Client sender;


    @JoinColumn(name = "receiver_id")
    @OneToOne
    private Client receiver;


    @NotNull
    private BigDecimal value;


}
