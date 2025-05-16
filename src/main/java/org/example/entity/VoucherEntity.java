package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "voucher")
@Getter
@Setter
@ToString
public class VoucherEntity {

    @Id
    @Column(unique = true)
    private String code;

    @ManyToOne
    @JoinColumn(name = "name")
    private OfferEntity offer;

    @ManyToOne
    @JoinColumn(name = "email")
    private RecipientEntity recipient;

    @Column
    private LocalDate expiredDate;

    @Column
    private LocalDate usedDate;

    @Column
    private Boolean used;
}
