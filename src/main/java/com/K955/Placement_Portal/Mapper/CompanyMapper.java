package com.K955.Placement_Portal.Mapper;

import com.K955.Placement_Portal.DTOs.Company.CompanyProfileRequest;
import com.K955.Placement_Portal.DTOs.Company.CompanyProfileResponse;
import com.K955.Placement_Portal.Entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "verified", ignore = true)
    Company toCompany(CompanyProfileRequest request);

    @Mapping(source = "user.name", target = "name")
    @Mapping(source = "user.email", target = "email")
    CompanyProfileResponse toCompanyProfileResponse(Company company);

}
