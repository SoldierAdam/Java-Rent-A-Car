package com.tobeto.pair9.entities.concretes;

import com.tobeto.pair9.entities.absracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "customers")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer extends BaseEntity {

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne()
    @JoinColumn(name="user_id")
    private User user;
}
