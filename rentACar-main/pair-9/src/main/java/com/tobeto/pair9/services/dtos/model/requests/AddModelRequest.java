package com.tobeto.pair9.services.dtos.model.requests;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
public class AddModelRequest {

    @Length(min=2,message = "The model name must be at least 2 character")
    private String name;

    @Positive(message = "Id must be greater than zero")
    private int brandId;

}
