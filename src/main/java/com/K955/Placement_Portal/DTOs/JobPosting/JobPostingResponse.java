package com.K955.Placement_Portal.DTOs.JobPosting;

import com.K955.Placement_Portal.Enums.JobPostingStatus;
import com.K955.Placement_Portal.Enums.JobType;

import java.time.Instant;
import java.util.List;

public record JobPostingResponse(
        Long id,
        String companyName,
        String companyLocation,
        String title,
        String description,
        String location,
        Double minSalary,
        Double maxSalary,
        JobType jobType,
        List<String> requiredSkills,
        Integer openings,
        JobPostingStatus jobPostingStatus,
        Instant postedAt,
        Instant deadline
) {
}
