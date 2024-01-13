package com.tobeto.pair9.entities.concretes;
import com.tobeto.pair9.entities.absracts.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name="brands")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Brand extends BaseEntity {

    @Column(name = "name")
    private String name;
    @Column(name= "logo_path")
    private String logoPath;

    @OneToMany(mappedBy = "brand")
    private List<Model>models;

}
