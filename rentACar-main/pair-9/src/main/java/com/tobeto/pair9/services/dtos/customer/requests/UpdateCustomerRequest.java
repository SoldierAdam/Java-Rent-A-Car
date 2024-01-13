package com.tobeto.pair9.services.dtos.customer.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {

    private int id;

    private String identityNumber;

    private String firstName;

    private String lastName;

    private int userId;
}
