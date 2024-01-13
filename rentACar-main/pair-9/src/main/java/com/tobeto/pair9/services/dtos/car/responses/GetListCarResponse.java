package com.tobeto.pair9.services.dtos.car.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListCarResponse {

    private Long kilometer;

    private String plate;

    private short modelYear;

    private Float dailyPrice;

    private short minFindeksRate;

    private String imagePath;

    private String modelName;

    private String colorName;

}
