package dev.katanoesis.paymenttest.entity;

import dev.katanoesis.paymenttest.BaseTimeEntity;
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
public class Movement extends BaseTimeEntity {

    @Id
    @SequenceGenerator(name = "seq_movement", sequenceName = "seq_movement", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_movement")
    private Integer num;

    @JoinColumn(name = "from_member")
    @ManyToOne
    private Member fromMember;

    @JoinColumn(name = "to_member")
    @ManyToOne
    private Member toMember;

    @JoinColumn(name = "gifticon_num")
    @ManyToOne
    private Gifticon gifticon;

}
