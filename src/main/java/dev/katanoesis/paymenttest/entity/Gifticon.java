package dev.katanoesis.paymenttest.entity;

import dev.katanoesis.paymenttest.BaseTimeEntity;
import dev.katanoesis.paymenttest.SaleStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Gifticon extends BaseTimeEntity {

    @Id
    @SequenceGenerator(name = "seq_gifticon", sequenceName = "seq_gificon", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gifticon")
    private Integer num;

    @JoinColumn(name = "member_num")
    @ManyToOne
    private Member member;

    private String barcode;
    private LocalDate due;
    private String usablePlace;
    private String product;
    @Enumerated(EnumType.ORDINAL)
    private SaleStatus status;
}
