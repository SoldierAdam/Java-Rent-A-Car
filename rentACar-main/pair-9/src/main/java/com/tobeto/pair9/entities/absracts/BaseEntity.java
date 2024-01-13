package com.tobeto.pair9.entities.absracts;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@MappedSuperclass
@Data
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "createdDate")
    private LocalDate createdDate;
    @Column(name = "updatedDate")
    private LocalDate updatedDate;
    @PrePersist
    private void beforeAdd(){
        createdDate = LocalDate.now();
    }
    @PreUpdate
    private void beforeUpdate(){
        updatedDate = LocalDate.now();
    }
}
