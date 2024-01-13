package com.tobeto.pair9.entities.concretes;

import com.tobeto.pair9.entities.absracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "colors")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Color extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name="code")
    private String code;

    @OneToMany(mappedBy = "color")
    private List<Car> cars;
}
