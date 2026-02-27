package com.K955.Placement_Portal.DTOs.Student;

import jakarta.validation.constraints.*;

import java.util.List;

public record StudentProfileRequest(

        @NotBlank
        String phoneNumber,

        @NotBlank
        String college,

        @NotBlank
        String degree,

        @NotBlank
        String branch,

        @NotNull
        @Min(2000)
        @Max(2040)
        Integer graduationYear,

        @DecimalMax("10.0")
        @DecimalMin("0.0")
        Double cgpa,

        List<String> skills

) {
}
