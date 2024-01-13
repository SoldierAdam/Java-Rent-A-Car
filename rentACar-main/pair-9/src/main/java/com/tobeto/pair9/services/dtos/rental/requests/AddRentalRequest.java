package com.tobeto.pair9.services.dtos.rental.requests;

import jakarta.validation.constraints.FutureOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRentalRequest {

    @FutureOrPresent(message = "Start date can't be any later than today!")
    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDate returnDate;

    private Long startKilometer;

    private Long endKilometer;

    private int carId;

    private int userId;
}
