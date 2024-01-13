package com.tobeto.pair9.services.dtos.color.requests;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateColorRequest {

    @Positive(message = "Id must be greater than zero")
    private int id;

    private String code;

    @Length(min=2,message = "The color name must be at least 2 character")
    private String name;
}
