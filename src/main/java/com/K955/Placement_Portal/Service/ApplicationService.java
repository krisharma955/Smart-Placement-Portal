package com.K955.Placement_Portal.Service;

import com.K955.Placement_Portal.DTOs.Application.ApplicationResponse;
import com.K955.Placement_Portal.DTOs.Application.UpdateApplicationStatusRequest;
import jakarta.validation.Valid;

import java.util.List;

public interface ApplicationService {
    ApplicationResponse createApplication(Long studentId, Long jobId);

    ApplicationResponse getApplicationById(Long applicationId);

    List<ApplicationResponse> getApplicationsByStudent(Long studentId);

    List<ApplicationResponse> getApplicationsByJob(Long jobId);

    ApplicationResponse updateApplicationStatus(Long applicationId, @Valid UpdateApplicationStatusRequest request);

    void withdrawApplication(Long applicationId);
}
