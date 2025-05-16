package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "offer")
@Getter
@Setter
@ToString
public class OfferEntity {

    @Id
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Double discount;
}
