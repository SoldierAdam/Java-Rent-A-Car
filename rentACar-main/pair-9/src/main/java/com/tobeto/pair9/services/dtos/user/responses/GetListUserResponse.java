package com.tobeto.pair9.services.dtos.user.responses;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListUserResponse {

    private int id;

    private String email;

    private String password;
}
