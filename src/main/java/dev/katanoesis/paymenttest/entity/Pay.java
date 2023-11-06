package dev.katanoesis.paymenttest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pay {

    @EmbeddedId
    private PayId payId;

}

@Embeddable
class PayId {

    @JoinColumn(name = "payee")
    @ManyToOne
    private Member payee;

    @JoinColumn(name = "payer")
    @ManyToOne
    private Member payer;

    @JoinColumn(name = "payment")
    @ManyToOne
    private Payment payment;

}