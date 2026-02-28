package com.K955.Placement_Portal.DTOs.Company;

public record UpdateCompanyRequest(
        String companyName,
        String website,
        String industry,
        String description,
        String location
) {
}
