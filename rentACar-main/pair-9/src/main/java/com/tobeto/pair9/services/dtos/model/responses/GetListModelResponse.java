package com.tobeto.pair9.services.dtos.model.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListModelResponse {

    private int id;

    private String name;

    private int brandId;
}
