package com.K955.Placement_Portal.Service;

import com.K955.Placement_Portal.DTOs.Company.CompanyProfileRequest;
import com.K955.Placement_Portal.DTOs.Company.CompanyProfileResponse;
import com.K955.Placement_Portal.DTOs.Company.UpdateCompanyRequest;
import jakarta.validation.Valid;

public interface CompanyService {
    CompanyProfileResponse createCompanyProfile(Long userId, @Valid CompanyProfileRequest request);

    CompanyProfileResponse getCompanyProfileById(Long userId);

    CompanyProfileResponse updateCompanyProfileById(Long userId, @Valid UpdateCompanyRequest request);

    void deleteCompanyProfileById(Long userId);
}
