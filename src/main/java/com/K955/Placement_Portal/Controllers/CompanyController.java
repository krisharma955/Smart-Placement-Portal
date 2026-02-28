package com.K955.Placement_Portal.Controllers;

import com.K955.Placement_Portal.DTOs.Company.CompanyProfileRequest;
import com.K955.Placement_Portal.DTOs.Company.CompanyProfileResponse;
import com.K955.Placement_Portal.DTOs.Company.UpdateCompanyRequest;
import com.K955.Placement_Portal.Service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("/profile/{userId}")
    public ResponseEntity<CompanyProfileResponse> createCompanyProfile(@PathVariable Long userId,
                                                                       @Valid @RequestBody CompanyProfileRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(companyService.createCompanyProfile(userId, request));
    }

    @GetMapping("/profile/{userId}")
    public ResponseEntity<CompanyProfileResponse> getCompanyProfile(@PathVariable Long userId) {
        return ResponseEntity.ok(companyService.getCompanyProfileById(userId));
    }

    @PatchMapping("/profile/{userId}")
    public ResponseEntity<CompanyProfileResponse> updateCompanyProfile(@PathVariable Long userId,
                                                                       @Valid @RequestBody UpdateCompanyRequest request) {
        return ResponseEntity.ok(companyService.updateCompanyProfileById(userId, request));
    }

    @DeleteMapping("/profile/{userId}")
    public ResponseEntity<Void> deleteCompanyProfile(@PathVariable Long userId) {
        companyService.deleteCompanyProfileById(userId);
        return ResponseEntity.noContent().build();
    }

}
