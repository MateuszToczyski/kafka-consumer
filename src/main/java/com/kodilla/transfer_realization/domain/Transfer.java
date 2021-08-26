package com.kodilla.transfer_realization.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "transfers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "recipient_account")
    private String recipientAccount;

    @Column(name = "sender_account")
    private String senderAccount;

    @Column(name = "title")
    private String title;

    @Column(name = "amount")
    private BigDecimal amount;
}
