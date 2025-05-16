package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "recipient")
@Getter
@Setter
@ToString
public class RecipientEntity {

    @Column(nullable = false)
    private String name;

    @Id
    @Column(nullable = false, unique = true)
    private String email;
}
