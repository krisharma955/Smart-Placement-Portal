package com.K955.Placement_Portal.DTOs.Student;

import jakarta.validation.constraints.*;

import java.util.List;

public record UpdateStudentRequest(
        String phoneNumber,

        String college,

        String degree,

        String branch,

        @Min(2000)
        @Max(2040)
        Integer graduationYear,

        @DecimalMax("10.0")
        @DecimalMin("0.0")
        Double cgpa,

        List<String> skills
) {
}
