package com.K955.Placement_Portal.Service;

import com.K955.Placement_Portal.DTOs.JobPosting.JobPostingRequest;
import com.K955.Placement_Portal.DTOs.JobPosting.JobPostingResponse;
import com.K955.Placement_Portal.DTOs.JobPosting.UpdateJobPostingRequest;
import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface JobPostingService {
    JobPostingResponse createJobPosting(Long userId, @Valid JobPostingRequest request);

    JobPostingResponse getJobPostingById(Long jobId);

    List<JobPostingResponse> getAllJobPostings();

    JobPostingResponse updateJobPostingById(Long jobId, @Valid UpdateJobPostingRequest request);

    void closeJobPosting(Long jobId);

    void deleteJobPosting(Long jobId);
}
