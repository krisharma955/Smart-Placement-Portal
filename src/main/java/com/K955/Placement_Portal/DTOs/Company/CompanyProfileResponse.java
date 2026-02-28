package com.K955.Placement_Portal.DTOs.Company;

import java.time.Instant;

public record CompanyProfileResponse(
        Long id,
        String name,
        String email,
        String companyName,
        String website,
        String industry,
        String description,
        String location,
        Boolean verified,
        Instant createdAt
) {
}
