package com.tobeto.pair9.services.dtos.brand.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddBrandRequest {

    @Length(min=2,message = "The brand name must be at least 2 character")
    private String name;

    private String logoPath;
}
