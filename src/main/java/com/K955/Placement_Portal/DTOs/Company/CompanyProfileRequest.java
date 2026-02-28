package com.K955.Placement_Portal.DTOs.Company;

import jakarta.validation.constraints.NotBlank;

public record CompanyProfileRequest(

        @NotBlank
        String companyName,

        String website,

        @NotBlank
        String industry,

        String description,

        @NotBlank
        String location

) {
}
