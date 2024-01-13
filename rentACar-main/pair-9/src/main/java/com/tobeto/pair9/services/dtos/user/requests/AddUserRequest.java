package com.tobeto.pair9.services.dtos.user.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {

    @NotNull
    private String email;
    @NotNull
    private String password;
}
