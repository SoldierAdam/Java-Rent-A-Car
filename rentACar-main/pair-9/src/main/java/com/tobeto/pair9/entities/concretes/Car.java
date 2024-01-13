package com.tobeto.pair9.entities.concretes;

import com.tobeto.pair9.entities.absracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "cars")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Car extends BaseEntity {

    @Column(name = "kilometer")
    private Long kilometer;

    @Column(name = "plate")
    private String plate;

    @Column(name = "model_year")
    private short modelYear;

    @Column(name = "daily_price")
    private Float dailyPrice;

    @Column(name = "min_findeks_rate")
    private short minFindeksRate;

    @Column(name = "image_path")
    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @OneToMany(mappedBy = "car")
    private List<Rental> rentals;

}
