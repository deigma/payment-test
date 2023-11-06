package dev.katanoesis.paymenttest.entity;

import dev.katanoesis.paymenttest.BaseTimeEntity;
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
public class Member extends BaseTimeEntity {

    @Id
    @SequenceGenerator(name = "seq_member", sequenceName = "seq_member", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_member")
    private Integer num;

    private String id;
    private String pwd;
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    private String memberType;
    private LocalDate birthDate;
    private String tel;
    private String account;

}
