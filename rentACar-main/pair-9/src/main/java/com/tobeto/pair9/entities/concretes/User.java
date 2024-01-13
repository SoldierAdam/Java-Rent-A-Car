package com.tobeto.pair9.entities.concretes;

import com.tobeto.pair9.entities.absracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "users")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {


    @Column(name = "email")
    private String email;

    @Column(name="password")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Rental> rentals;

}
