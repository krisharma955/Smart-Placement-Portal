package com.K955.Placement_Portal.DTOs.Student;

import java.util.List;

public record StudentProfileResponse(
        Long id,
        String name,
        String email,
        String phoneNumber,
        String college,
        String degree,
        String branch,
        Integer graduationYear,
        Double cgpa,
        List<String> skills,
        Boolean profileComplete
) {
}
