package com.K955.Placement_Portal.DTOs.Auth;

import com.K955.Placement_Portal.Enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record SignupRequest(

        @NotBlank
        @Size(min = 3, max = 30)
        String name,

        @Email
        @NotBlank
        String email,

        @NotBlank
        @Size(min = 4, max = 50)
        String password,

        @NotNull
        Role role

        ) {
}
