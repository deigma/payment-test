package dev.katanoesis.paymenttest.entity;

import dev.katanoesis.paymenttest.BaseTimeEntity;
import dev.katanoesis.paymenttest.PayMethod;
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
public class Payment extends BaseTimeEntity {

    @Id
    @SequenceGenerator(name = "seq_payment", sequenceName = "seq_payment", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_payment")
    private Integer num;

    private Long price;

    @Enumerated(EnumType.STRING)
    private PayMethod method;

}
