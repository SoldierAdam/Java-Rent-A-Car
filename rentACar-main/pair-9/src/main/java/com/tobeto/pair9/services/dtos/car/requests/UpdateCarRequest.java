package com.tobeto.pair9.services.dtos.car.requests;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarRequest {

    @Positive(message = "Id must be greater than zero")
    private int id;

    @Positive(message = "Km must be greater than zero")
    private Long kilometer;
    @NotBlank(message = "Plate cannot null!")
    @Pattern(regexp = "^(0[1-9]|[1-8][0-9]|9[0-8])[A-Z\s]{1,3}\\d{2,4}$", message = "Invalid Turkish license plate format!")
    private String plate;

    @Min(value=2005,message ="Year must be greater than 2005" )
    @Max(value=2024,message ="Year must be smaller than 2024")
    private short modelYear;

    @Positive(message = "Price must be greater than zero")
    private Float dailyPrice;

    private short minFindeksRate;

    private String imagePath;

    @Positive(message = "Id must be greater than zero")
    private int modelId;

    @Positive(message = "Id must be greater than zero")
    private int colorId;
}
